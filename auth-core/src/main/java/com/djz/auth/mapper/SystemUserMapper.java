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


    /**
     *
     * @param page
     * @param info
     * @param status
     * @param startTime
     * @param endTime
     * @return
     */
    List<SysUser> selectPageByConditionUser(Page<SysUser> page, @Param("info") String info,
                                            @Param("status") Integer [] status, @Param("startTime")String startTime, @Param("endTime")String endTime);


}
