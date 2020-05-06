package com.caler.zkl.openpsd.service.impl;

import com.caler.zkl.openpsd.bean.*;
import com.caler.zkl.openpsd.mapper.MenuMapper;
import com.caler.zkl.openpsd.service.MenuService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Caler_赵康乐
 * @create 2020-04-26 12:23
 * @description :
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;



    @Override
    public int create(Menu menu) {
        menu.setCreateTime(new Date());
        if(menu.getParentId()==0){
            menu.setLevel(0);
        }else{
            menu.setLevel(1);
        }
        return menuMapper.insertSelective(menu);
    }

    @Override
    public int update(Menu menu) {
        if(menu.getParentId()==0){
            menu.setLevel(0);
        }else{
            menu.setLevel(1);
        }
        return menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public int delete(List<Long> ids) {//删除上级下级一起删除
        int count = 0;
        for (long id : ids) {
            count += menuMapper.deleteByPrimaryKey(id);
            MenuExample example = new MenuExample();
            example.createCriteria().andParentIdEqualTo(id);
            count += menuMapper.deleteByExample(example);
        }
        return count;
    }

    @Override
    public Menu list(Long id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Menu> list() {
        return menuMapper.selectByExample(null);
    }

    @Override
    public List<Menu> list(Long pid,String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        MenuExample example = new MenuExample();
        if (keyword != null) {
            example.createCriteria().andNameLike("%" + keyword + "%");
        }
        example.createCriteria().andParentIdEqualTo(pid);
        //设置条件
        return menuMapper.selectByExample(example);
    }

    @Override
    public List<Menu> list(Menu menu, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        MenuExample example = new MenuExample();
        //设置条件
        return menuMapper.selectByExample(example);
    }

    @Override
    public List<MenuNode> treeList() {
        List<Menu> menuList = menuMapper.selectByExample(new MenuExample());
        List<MenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    /**
     * 将Menu转化为MenuNode并设置children属性
     */
    private MenuNode covertMenuNode(Menu menu, List<Menu> menuList) {
        MenuNode node = new MenuNode();
        BeanUtils.copyProperties(menu, node);
        List<MenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }


}
