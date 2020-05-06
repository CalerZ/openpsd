package com.caler.zkl.openpsd.bean;

import lombok.Data;

import java.util.List;

/**
 * @author Caler_赵康乐
 * @create 2020-05-01 18:58
 * @description :
 */
@Data
public class MenuNode extends Menu {
    private List<MenuNode> children;
}
