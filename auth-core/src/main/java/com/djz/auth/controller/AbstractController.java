package com.djz.auth.controller;


import com.djz.auth.entity.sys.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * AbstractController
 *
 * @author djz
 * @email 1175639137@qq.com
 * @description
 */
public class AbstractController {

    protected SysUser getUser(){
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId(){
        return getUser().getUserId();
    }
}
