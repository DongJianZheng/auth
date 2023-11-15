package com.djz.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.djz.auth.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper 接口
 * @author djz
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findMenuByRoleCode(@Param("roleCode") String roleCode);
}
