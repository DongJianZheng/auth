package com.djz.auth.mapper.sys;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.djz.auth.entity.sys.SysUserRole;

import java.util.List;

/**
 * SysUserRoleMapper
 *
 * @author Zoey
 *
 * @email 1175639137@qq.com
 * @description
 */

public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * 查询roleId
     * @param userId
     * @return
     */
    List<Integer> queryRoleIdList(Integer userId);
}
