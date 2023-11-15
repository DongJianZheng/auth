package com.djz.auth.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.djz.auth.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper 接口
 * @author djz
 */
public interface SystemUserMapper extends BaseMapper<SysUser> {


    //等同于编写一个普通 list 查询，mybatis-plus 自动替你分页
    List<SysUser> selectPageByConditionUser(Page<SysUser> page, @Param("info") String info,
                                            @Param("status") Integer [] status, @Param("startTime")String startTime, @Param("endTime")String endTime);


}
