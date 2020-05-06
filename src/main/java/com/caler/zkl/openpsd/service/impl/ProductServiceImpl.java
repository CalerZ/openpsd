package com.caler.zkl.openpsd.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.exception.BizException;
import com.caler.zkl.openpsd.mapper.ProductMapper;
import com.caler.zkl.openpsd.mapper.PurchaseMethodMapper;
import com.caler.zkl.openpsd.mapper.StockMapper;
import com.caler.zkl.openpsd.service.MemberService;
import com.caler.zkl.openpsd.service.ProductService;
import com.caler.zkl.openpsd.service.StockService;
import com.caler.zkl.openpsd.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 12:23
 * @description :
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private PurchaseMethodMapper purchaseMethodMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int create(ProductDetail productDetail) {
        int count = 0;
        Product product = productDetail.getProduct();
        product.setCreateTime(DateTime.now().toStringDefaultTimeZone());
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        if (StrUtil.isEmpty(username)) {
            throw new BizException("用户未登录或用户名不存在！");
        }
        product.setCreateOn(memberService.selectByName(username).getId());
        count += productMapper.insertSelective(product);
        Stock stock = productDetail.getStock();
        stock.setProductId(product.getId());
        stock.setProductCode(product.getCode());
        count += stockMapper.insertSelective(stock);
        return count;
    }

    @Override
    public int update(ProductDetail productDetail) {
        int count = 0;
        Product product = productDetail.getProduct();
        product.setModifyTime(DateTime.now().toStringDefaultTimeZone());
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        if (StrUtil.isEmpty(username)) {
            throw new BizException("用户未登录或用户名不存在！");
        }
        product.setModifyOn(memberService.selectByName(username).getId());
        count += productMapper.updateByPrimaryKeySelective(product);
        Stock stock = productDetail.getStock();
        count += stockMapper.updateByPrimaryKeySelective(stock);
        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id : ids) {
            count += productMapper.deleteByPrimaryKey(id);
            StockExample example = new StockExample();
            example.createCriteria().andProductIdEqualTo(id);
            stockMapper.deleteByExample(example);
        }
        return count;
    }

    @Override
    public int delete(Long id) {
        int count = 0;
        count += productMapper.deleteByPrimaryKey(id);
        StockExample example = new StockExample();
        example.createCriteria().andProductIdEqualTo(id);
        stockMapper.deleteByExample(example);
        return count;
    }

    @Override
    public List<PurchaseMethod> purchaseMethodlist() {
        PurchaseMethodExample example = new PurchaseMethodExample();
        List<PurchaseMethod> purchaseMethods = purchaseMethodMapper.selectByExample(example);
        return purchaseMethods;
    }

    @Override
    public List<ApplicationProduct> applicationProductList(List<Long> ids) {
        ProductExample example = new ProductExample();
        example.createCriteria().andIdIn(ids);
        List<Product> products = productMapper.selectByExample(example);
        List<ApplicationProduct> applicationProducts = products.stream().map(product -> {
            ApplicationProduct applicationProduct = new ApplicationProduct();
            applicationProduct.setProductName(product.getName());
            applicationProduct.setProductCode(product.getCode());
            applicationProduct.setProductId(product.getId());

            applicationProduct.setType1(product.getType1());
            applicationProduct.setType2(product.getType2());
            applicationProduct.setDescription(product.getDescription());
            applicationProduct.setSpecifications(product.getSpecifications());
            applicationProduct.setUnit(product.getUnit());
            applicationProduct.setPrice(product.getPrice());
            applicationProduct.setStandard(product.getStandard());

            //库存
            StockExample stockExample = new StockExample();
            stockExample.createCriteria().andProductIdEqualTo(product.getId());
            List<Stock> stocks = stockMapper.selectByExample(stockExample);
            Stock stock = stocks.get(0);
            applicationProduct.setSafetyStock(stock.getSafetyStock());
            applicationProduct.setOnHandInventory(stock.getOnHandInventory());
            applicationProduct.setReportedQuantity(stock.getReportedQuantity());
            applicationProduct.setPurchaseMethod(stock.getPurchaseMethod());
            applicationProduct.setProdLineMembers(stock.getProdLineMembers());
            applicationProduct.setLastMonthQuantity(stock.getLastMonthQuantity());

            return applicationProduct;
        }).collect(Collectors.toList());
        return applicationProducts;
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
    public List<Product> list() {
        return productMapper.selectByExample(null);
    }

    @Override
    public List<Product> list(Product product, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        ProductExample example = new ProductExample();
        //设置条件
        return productMapper.selectByExample(example);
    }
}
