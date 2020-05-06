package com.caler.zkl.openpsd.service.impl;

import cn.hutool.core.util.StrUtil;
import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.mapper.ProductTypeMapper;
import com.caler.zkl.openpsd.service.ProductTypeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 12:23
 * @description :
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public int create(ProductType productType) {
        productType.setCreateTime(new Date());
        if(productType.getpId()!=0){
            productType.setLevel(1);
        }else {
            productType.setLevel(0);
        }
        return productTypeMapper.insertSelective(productType);
    }

    @Override
    public int update(ProductType productType) {
        return productTypeMapper.updateByPrimaryKeySelective(productType);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id:ids) {
           count+= productTypeMapper.deleteByPrimaryKey(id);
        }
        return count;
    }
    @Override
    public int delete(Long id) {
        return  productTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ProductType list(Long id) {
        return productTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProductType> list() {
        return productTypeMapper.selectByExample(null);
    }

    @Override
    public List<ProductType> list(Long pid,String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        ProductTypeExample example = new ProductTypeExample();
        example.createCriteria().andPIdEqualTo(pid);
        if(!StrUtil.isEmpty(keyword))
            example.createCriteria().andTypeNameLike("%"+keyword+"%");
        //设置条件
        return productTypeMapper.selectByExample(example);
    }

    @Override
    public List<ProductTypeNode> treeList() {
        List<ProductType> productTypeList = productTypeMapper.selectByExample(null);
        List<ProductTypeNode> result = productTypeList.stream()
                .filter(ptype -> ptype.getpId().equals(0L))
                .map(ptype -> covertMenuNode(ptype, productTypeList)).collect(Collectors.toList());
        return result;
    }

    private ProductTypeNode covertMenuNode(ProductType ptype, List<ProductType> menuList) {
        ProductTypeNode node = new ProductTypeNode();
        BeanUtils.copyProperties(ptype, node);
        List<ProductTypeNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getpId().equals(ptype.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
