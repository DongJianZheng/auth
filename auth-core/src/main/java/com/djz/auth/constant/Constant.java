package com.djz.auth.constant;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author djz
 */
public class Constant {


    public static Set<String>  METHOD_URL_SET = Sets.newConcurrentHashSet();

    /**
     * 根菜单节点
     */
    public static final String ROOT_MENU = "0";

    /**
     * 菜单类型，1：菜单  2：按钮操作
     */
    public static final int TYPE_MENU = 1;

    /**
     * 菜单类型，1：菜单  2：按钮操作
     */
    public static final int TYPE_BUTTON = 2;
}
