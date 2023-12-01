package com.djz.auth.mapper.sys;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.djz.auth.entity.sys.SysRole;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author djz
 **/
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 查询所属角色
     * @param createUserId
     * @return
     */
    List<Integer> queryRoleIdList(Integer createUserId);
}
