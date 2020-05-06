package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.Company;
import com.caler.zkl.openpsd.bean.CompanyExample;
import com.caler.zkl.openpsd.mapper.CompanyMapper;
import com.caler.zkl.openpsd.service.CompanyService;
import com.caler.zkl.openpsd.service.CompanyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 12:23
 * @description :
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public int create(Company company) {
        return companyMapper.insertSelective(company);
    }

    @Override
    public int update(Company company) {
        return companyMapper.updateByPrimaryKeySelective(company);
    }

    @Override
    public int delete(List<Long> ids) {
        int count = 0;
        for (long id : ids) {
            count += companyMapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public Company list(Long id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Company> list() {
        return companyMapper.selectByExample(null);
    }

    @Override
    public List<Company> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        CompanyExample example = new CompanyExample();
        if (keyword != null && !keyword.equals(""))
            example.createCriteria().andNameLike("%" + keyword + "%");
        //设置条件
        return companyMapper.selectByExample(example);
    }

    @Override
    public int delete(Long id) {
        return companyMapper.deleteByPrimaryKey(id);
    }
}
