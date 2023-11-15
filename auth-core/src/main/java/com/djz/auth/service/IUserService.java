package com.djz.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.djz.auth.entity.SysUser;
import com.djz.auth.vo.LoginRequestVO;

import java.util.Map;

/**
 * 服务类
 * @author djz
 */
public interface IUserService extends IService<SysUser> {


    /**
     *
     * @param loginRequestVO 登录请求对象
     * @return Map<String,Object>
     */
    Map<String,Object> checkMobileAndPasswd(LoginRequestVO loginRequestVO);

    Map<String, Object> getLoginUserAndMenuInfo(SysUser user);
}
