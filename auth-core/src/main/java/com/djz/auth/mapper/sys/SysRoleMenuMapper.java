package com.djz.auth.mapper.sys;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.djz.auth.entity.sys.SysRoleMenu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author djz
 **/
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * 根据roleId查询所属menuId
     * @param roleId
     * @return
     */
    List<Integer> queryMenuIdList(Integer roleId);
}
