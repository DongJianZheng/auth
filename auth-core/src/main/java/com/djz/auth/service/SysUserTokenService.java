package com.djz.auth.service;

import com.djz.auth.entity.sys.SysUserToken;
import com.djz.auth.vo.Result;

/**
 * SysUserTokenService
 *
 * @author djz
 * @email 1175639137@qq.com
 * @description
 */
public interface SysUserTokenService {
    /**
     * 生成Token
     * @param userId
     * @return
     */
    Result createToken(Long userId);

    /**
     * 查询token
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);

    /**
     * 退出登录
     * @param userId
     */
    void logout(Long userId);

    /**
     * 续期
     * @param userId
     * @param token
     */
    void refreshToken(Integer userId, String token);
}
