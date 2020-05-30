package com.caler.zkl.openpsd.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.bean.ImportProductData;
import com.caler.zkl.openpsd.mapper.ProductSupplierMapper;
import com.caler.zkl.openpsd.service.*;
import com.caler.zkl.openpsd.util.ExcelUtil;
import com.caler.zkl.openpsd.util.UserServiceUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-14 15:22
 * @description :
 */
@Service
public class ExcelDataServiceImpl implements ExcelDataService {

    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private ProductUtilService productUtilService;
    @Autowired
    private PurchaseMethodService purchaseMethodService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserServiceUtil userServiceUtil;
    @Resource
    private ProductSupplierMapper productSupplierMapper;

    List<ProductType> productTypeList = new ArrayList<>();
    List<ProductUtil> productUtilList = new ArrayList<>();
    List<PurchaseMethod> purchaseMethodList = new ArrayList<>();
    List<Supplier> supplierList = new ArrayList<>();


    @Override
    public List<ExcelImportResult> importProduct(MultipartFile file) {
        productTypeList = productTypeService.list();
        productUtilList = productUtilService.list();
        purchaseMethodList = purchaseMethodService.list();
        supplierList = supplierService.list();


        List<ExcelImportResult> result = new ArrayList<>();
        List<ImportProductData> list = ExcelUtil.readExcel("", ImportProductData.class, file);
        System.out.println(list);
        //验证
        if (list == null || list.size() < 1) {
            return result;
        }
        for (ImportProductData item : list) {
            ExcelImportResult result1 = new ExcelImportResult();

            StringBuffer msg = new StringBuffer();
            Product p = new Product();
            Stock s = new Stock();
            //1.类型  （层级是否符合）
            if ((StrUtil.isEmpty(item.getType1())
                    || StrUtil.isEmpty(item.getUnit())
                    || StrUtil.isEmpty(item.getPurchaseMethod())
                    || StrUtil.isEmpty(item.getSuppliers().trim())
                    || StrUtil.isEmpty(item.getProductName())
                    || StrUtil.isEmpty(item.getPrice())

            )) {
                result1.setProductName(item.getProductName());
                result1.setResult("导入失败");
                result1.setType(item.getType1() + (StrUtil.isEmpty(item.getType2()) ? "" : "_" + item.getType2()));
                result1.setMessage("必填值为空，请检查");
                result.add(result1);
                continue;
            }

            productTypeList.stream().forEach(pt -> {
                if (item.getType1() != null && pt.getTypeName().equals(item.getType1().trim())) {
                    p.setType1(pt.getId());
                }
            });
            if (p.getType1() == null || "".equals(p.getType1())) {
                msg.append("类型1不存在；");
            }
            productTypeList.stream().forEach(pt -> {
                if (item.getType2() != null && pt.getTypeName().equals(item.getType2().trim())) {
                    p.setType2(pt.getId());
                }
            });
           /* if (p.getType2() == null || "".equals(p.getType2())) {
                msg.append("类型2不存在；");
                return;
            }*/
            //2.单位
            productUtilList.stream().forEach(pu -> {
                if (item.getUnit() != null && pu.getUtilName().equals(item.getUnit().trim())) {
                    p.setUnit(pu.getId());
                }
            });
            if (p.getUnit() == null || "".equals(p.getUnit())) {
                msg.append("单位不存在；");
            }
            //3.采购方式
            purchaseMethodList.stream().forEach(pm -> {
                if (item.getPurchaseMethod() != null && pm.getName().equals(item.getPurchaseMethod().trim())) {
                    s.setPurchaseMethod(pm.getId());
                }
            });
            if (s.getPurchaseMethod() == null || "".equals(s.getPurchaseMethod())) {
                msg.append("采购方式不存在；");
            }
            //4.供应商
            String sus = item.getSuppliers().trim();
            String[] arr = sus.split(",");
            List<String> slist = new ArrayList<>();
            if (arr != null && arr.length > 0) {
                for (String t : arr) {
                    for (Supplier su : supplierList) {
                        if (su.getName().equals(t)) {
                            slist.add(su.getId() + "");
                        }
                    }

                }

            }
            if (slist.size() != arr.length) {
                msg.append("供应商导入不完整，请检查；");
            }
            if (slist.size() != 0) {
                p.setSupplierId(String.join(",", slist));
            } else {
                msg.append("供应商不存在；");
            }
            //价格
            if (!"".equals(item.getPrice())) {
                p.setPrice(Double.parseDouble(item.getPrice()));
            } else {
                msg.append("价格为空；");
            }
            //编号
            String productNo = productService.getProductNo(p.getType1(), p.getType2());
            if (!StrUtil.isEmpty(productNo)) {
                p.setCode(productNo);
            } else {
                msg.append("物料编码生成失败；");
            }
            //5.状态
            if ("1".equals(item.getStatus())) {
                p.setStatus(1);
            } else if ("0".equals(item.getStatus())) {
                p.setStatus(0);
            } else {
                p.setStatus(0);
            }
            //6.名称
            if (!StrUtil.isEmpty(item.getProductName())) {
                p.setName(item.getProductName());
            } else {
                msg.append("物料名称为空；");
            }

            //7.规格
            p.setSpecifications(item.getSpecifications());
            //8.标准
            p.setStandard(item.getStandard());
            //9.厂区人数
            s.setProdLineMembers(Integer.getInteger(item.getProdLineMembers() == null ? "0" : item.getProdLineMembers()));
            //10.安全库存
            s.setSafetyStock(Double.parseDouble(item.getSafetyStock() == null ? "0" : item.getSafetyStock()));
            //11.上月数量
            s.setLastMonthQuantity(Double.parseDouble(item.getLastMonthQuantity() == null ? "0" : item.getLastMonthQuantity()));
            //12.现有库存
            s.setOnHandInventory(Double.parseDouble(item.getOnHandInventory() == null ? "0" : item.getOnHandInventory()));
            //13.本月提报数量
            s.setReportedQuantity(Double.parseDouble(item.getReportedQuantity() == null ? "0" : item.getReportedQuantity()));

            ProductDetail detail = new ProductDetail();
            detail.setStock(s);
            p.setCreateTime(DateUtil.now());
            p.setCreateOn(userServiceUtil.getUser().getId());
            detail.setProduct(p);
            productService.create(detail);
            //物料与供应商关联
            String supplierIds = p.getSupplierId();
            String[] sidArr = supplierIds.split(",");
            for (String sid : sidArr) {
                ProductSupplierExample example = new ProductSupplierExample();
                example.createCriteria().andProductIdEqualTo(p.getId()).andSupplierIdEqualTo(Long.valueOf(sid));
                if (productSupplierMapper.selectByExample(example).size() == 0) {
                    ProductSupplier productSupplier = new ProductSupplier();
                    productSupplier.setProductId(p.getId());
                    productSupplier.setSupplierId(Long.valueOf(sid));
                    productSupplierMapper.insertSelective(productSupplier);
                }
            }
            if (!"".equals(msg.toString())) {
                result.add(new ExcelImportResult(item.getProductName(), item.getType1() + (StrUtil.isEmpty(item.getType2()) ? "" : "_" + item.getType2()), "导入失败", msg.toString()));
            } else {
                result.add(new ExcelImportResult(item.getProductName(), item.getType1() + (StrUtil.isEmpty(item.getType2()) ? "" : "_" + item.getType2()), "导入成功", msg.toString()));

            }
        }
        return result;
    }

}
