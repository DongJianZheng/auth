package com.djz.auth.service.impl;


import com.djz.auth.constant.RedisKeyConstants;
import com.djz.auth.entity.sys.SysUserToken;
import com.djz.auth.service.SysUserTokenService;
import com.djz.auth.vo.Result;
import com.djz.auth.vo.TokenGenerator;
import com.djz.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * SysUserTokenServiceImpl
 *
 * @author djz
 * @email 1175639137@qq.com
 * @description
 */
@Service
public class SysUserTokenServiceImpl implements SysUserTokenService {

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 生成Token
     *
     * @param userId
     * @return
     */
    @Override
    public Result createToken(Long userId) {
        // 生成一个token
        String token = TokenGenerator.generateValue();

        String tokenKey= RedisKeyConstants.MANAGE_SYS_USER_TOKEN+token;
        String userIdKey= RedisKeyConstants.MANAGE_SYS_USER_TOKEN+userId;

        //判断是否生成过token
        String tokenInRedis=redisUtils.get(userIdKey);
        if(!StringUtils.isEmpty(tokenInRedis)){
            // 将原来的token删除
            redisUtils.delete(RedisKeyConstants.MANAGE_SYS_USER_TOKEN+tokenInRedis);
        }
        // 将token存进redis
        redisUtils.set(tokenKey,userId,EXPIRE);
        redisUtils.set(userIdKey,token,EXPIRE);

        return new Result().put("token",token).put("expire",EXPIRE);
    }

    /**
     * 查询token
     *
     * @param token
     * @return
     */
    @Override
    public SysUserToken queryByToken(String token) {
        String userId=redisUtils.get(token);
        if(StringUtils.isEmpty(userId)){
            return null;
        }
        SysUserToken sysUserToken=new SysUserToken();
        sysUserToken.setToken(token);
        sysUserToken.setUserId(Integer.parseInt(userId));
        return sysUserToken;
    }

    /**
     * 退出登录
     *
     * @param userId
     */
    @Override
    public void logout(Long userId) {
        String userIdKey= RedisKeyConstants.MANAGE_SYS_USER_TOKEN+userId;
        String token=redisUtils.get(userIdKey);
        String tokenKey= RedisKeyConstants.MANAGE_SYS_USER_TOKEN+token;
        redisUtils.delete(userIdKey);
        redisUtils.delete(tokenKey);
    }

    /**
     * 续期
     *
     * @param userId
     * @param token
     */
    @Override
    public void refreshToken(Integer userId, String token) {
        String tokenKey= RedisKeyConstants.MANAGE_SYS_USER_TOKEN+token;
        String userIdKey= RedisKeyConstants.MANAGE_SYS_USER_TOKEN+userId;
        redisUtils.updateExpire(tokenKey);
        redisUtils.updateExpire(userIdKey);
    }


}
