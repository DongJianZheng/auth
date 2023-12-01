package com.djz.auth.mapper.sys;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.djz.auth.entity.sys.SysUser;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author djz
 **/

public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询用户所有权限
     * @param userId
     * @return
     */
    List<String> queryAllPerms(Integer userId);

    /**
     * 查询用户的menuId
     * @param userId
     * @return
     */
    List<Integer> queryAllMenuId(Integer userId);
}
