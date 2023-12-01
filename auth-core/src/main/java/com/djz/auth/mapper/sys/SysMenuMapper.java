package com.djz.auth.mapper.sys;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.djz.auth.entity.sys.SysMenu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author djz
 **/
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 查询非按钮的菜单
     * @return
     */
    List<SysMenu> queryNotButtonList();

    /**
     * 根据parentId查询菜单
     * @param parentId
     * @return
     */
    List<SysMenu> queryListParentId(Integer parentId);
}
