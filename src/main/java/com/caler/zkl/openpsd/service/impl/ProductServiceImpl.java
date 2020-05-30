package com.caler.zkl.openpsd.service.impl;

import cn.hutool.core.date.DateTime;
import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.mapper.*;
import com.caler.zkl.openpsd.service.ProductService;
import com.caler.zkl.openpsd.util.UserServiceUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Caler_赵康乐
 * @create 2020-04-26 12:23
 * @description :
 */
@Service
public class ProductServiceImpl implements ProductService {

    //    @Autowired
    @Resource
    private ProductMapper productMapper;
    @Autowired
    private ProductDao productDao;

    @Autowired
    private PurchaseMethodMapper purchaseMethodMapper;
    @Autowired
    private UserServiceUtil userServiceUtil;
    @Autowired
    private SysDictMapper sysDictMapper;

    @Resource
    private ProductTypeMapper productTypeMapper;
    @Resource
    private ProductUtilMapper productUtilMapper;
    @Resource
    private StockMapper stockMapper;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private SupplierMapper supplierMapper;
    @Resource
    private ProductSupplierMapper productSupplierMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int create(ProductDetail productDetail) {
        int count = 0;
        Product product = productDetail.getProduct();
        product.setCreateTime(DateTime.now().toStringDefaultTimeZone());
        product.setCreateOn(userServiceUtil.getUser().getId());
        product.setIsDelete(0);
        count += productMapper.insertSelective(product);
        Stock stock = productDetail.getStock();
        stock.setProductId(product.getId());
        stock.setProductCode(product.getCode());
        stockMapper.insertSelective(stock);
        String supplierIds = product.getSupplierId();
        String[] sidArr = supplierIds.split(",");
        for (String sid : sidArr) {
            ProductSupplier productSupplier = new ProductSupplier();
            productSupplier.setProductId(product.getId());
            productSupplier.setSupplierId(Long.valueOf(sid));
            productSupplierMapper.insertSelective(productSupplier);
        }
        return count;
    }

    @Override
    public int update(ProductDetail productDetail) {
        int count = 0;
        Product product = productDetail.getProduct();
        product.setModifyTime(DateTime.now().toStringDefaultTimeZone());
        product.setModifyOn(userServiceUtil.getUser().getId());
        product.setModifyTime(DateTime.now().toStringDefaultTimeZone());
        count += productMapper.updateByPrimaryKeySelective(product);
        Stock stock = productDetail.getStock();
        count += stockMapper.updateByPrimaryKeySelective(stock);
        //删除供应商后重新添加
        ProductSupplierExample example = new ProductSupplierExample();
        example.createCriteria().andProductIdEqualTo(product.getId());
        productSupplierMapper.deleteByExample(example);
        String supplierIds = product.getSupplierId();
        String[] sidArr = supplierIds.split(",");
        for (String sid : sidArr) {
            ProductSupplier productSupplier = new ProductSupplier();
            productSupplier.setProductId(product.getId());
            productSupplier.setSupplierId(Long.valueOf(sid));
            productSupplierMapper.insertSelective(productSupplier);
        }
        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id : ids) {
            Product product = new Product();
            product.setId(id);
            product.setIsDelete(1);
            count += productMapper.updateByPrimaryKeySelective(product);
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setIsDelete(1);
        return productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public List<PurchaseMethod> purchaseMethodlist() {
        PurchaseMethodExample example = new PurchaseMethodExample();
        example.setOrderByClause(" id desc");
        List<PurchaseMethod> purchaseMethods = purchaseMethodMapper.selectByExample(example);
        return purchaseMethods;
    }

    @Override
    public List<ProductPojo> applicationProductList(List<Long> ids) {
        List<ProductPojo> pojos = ids.stream().map(item -> {
            if (item != null) {
                return selectOne(item);
            }
            return null;
        }).collect(Collectors.toList());
        return pojos;
    }

    @Override
    public String getProductNo(Long type1, Long type2) {
        //编码规则
        SysDictExample example = new SysDictExample();
        example.createCriteria().andDataTypeEqualTo("3");
        example.setOrderByClause("sort");
        List<SysDict> dicts = sysDictMapper.selectByExample(example);
        final StringBuilder partNo = new StringBuilder();
        //获取类型编码
        ProductType productType1 = productTypeMapper.selectByPrimaryKey(type1);
        ProductType productType2 = productTypeMapper.selectByPrimaryKey(type2);


        dicts.forEach(item -> {
            if ("t1".equals(item.getDataCode())) {//标识
                partNo.append(item.getDataValue());
            }
            if ("t2".equals(item.getDataCode()) && productType1 != null) {
                partNo.append("-");
                partNo.append("".equals(productType1.getCode()) ? 0 : productType1.getCode());
            }
            if ("t3".equals(item.getDataCode()) && productType2 != null) {
                partNo.append("-");
                partNo.append("".equals(productType2.getCode()) ? 0 : productType2.getCode());
            }
            if ("t4".equals(item.getDataCode())) {
                partNo.append("-");
                String maxPartNo = productDao.selectMaxPartNo(partNo.toString() + "%");
                if (maxPartNo == null || "".equals(maxPartNo)) {
                    String no = String.format("%0" + item.getDataValue() + "d", 1);
                    partNo.append(no);
                } else {
                    int maxNo = Integer.parseInt(maxPartNo.substring(partNo.toString().length()));
                    String no = String.format("%0" + item.getDataValue() + "d", maxNo + 1);
                    partNo.append(no);
                }
            }

        });
        return partNo.toString();
    }

    @Override
    public int updateStatus(Long id, String status) {
        Product product = new Product();
        product.setId(id);
        product.setStatus(Integer.valueOf(status));
        return productMapper.updateByPrimaryKeySelective(product);
    }


    @Override
    public ProductDetail list(Long id) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(productMapper.selectByPrimaryKey(id));
        StockExample example = new StockExample();
        example.createCriteria().andProductIdEqualTo(id);
        List<Stock> stocks = stockMapper.selectByExample(example);
        productDetail.setStock(stocks.get(0));
        return productDetail;
    }

    @Override
    public ProductPojo selectOne(Long id) {
        ProductPojo productPojo = new ProductPojo();
        Product product = productMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(product, productPojo);
        productPojo.setProductType1(productTypeMapper.selectByPrimaryKey(product.getType1()));
        if (product.getType2() != null) {
            productPojo.setProductType2(productTypeMapper.selectByPrimaryKey(product.getType2()));
        }
        if (product.getUnit() != null) {
            productPojo.setProductUtil(productUtilMapper.selectByPrimaryKey(product.getUnit()));
        }
        StockExample example = new StockExample();
        example.createCriteria().andProductIdEqualTo(product.getId());
        List<Stock> stocks = stockMapper.selectByExample(example);
        if (stocks.size() > 0) {
            productPojo.setStock(stocks.get(0));
            productPojo.setPurchaseMethod(purchaseMethodMapper.selectByPrimaryKey(stocks.get(0).getPurchaseMethod()));
        }
        productPojo.setMember(memberMapper.selectByPrimaryKey(product.getCreateOn()));
        String supplierId = product.getSupplierId();
        String[] sids = supplierId.split(",");

        List<Supplier> supplierList = Arrays.stream(sids).map(sid -> {
            if (sid != null) {
                Supplier supplier = supplierMapper.selectByPrimaryKey(Long.valueOf(sid));
                return supplier;
            }
            return null;
        }).collect(Collectors.toList());
        productPojo.setSupplierList(supplierList);
        return productPojo;
    }

    @Override
    public List<Product> list() {
        ProductExample example = new ProductExample();
        example.createCriteria().andIsDeleteEqualTo(0);
        example.setOrderByClause(" id desc");
        return productMapper.selectByExample(null);
    }


    public List<Product> list1(String keyword, Long typeid, Integer status, Long createrid, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ProductExample example = new ProductExample();
        ProductExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo(0);
        if (keyword != null) {
            criteria.andNameLike("%" + keyword + "%");
            example.or(example.createCriteria().andCodeLike("%" + keyword + "%"));
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        if (typeid != null) {
            criteria.andType1EqualTo(typeid);
            example.or(example.createCriteria().andType2EqualTo(typeid));
        }
        if (createrid != null) {
            criteria.andCreateOnEqualTo(createrid);
        }
        example.setOrderByClause(" id desc");
        return productMapper.selectByExample(example);
    }

    @Override
    public List<ProductBean> list(String keyword, Long typeid, Integer status, Long createrid, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return productDao.select(keyword, typeid, status, createrid);
    }



}
