package com.djz.auth.entity.sys;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * 用户管理
 * </p>
 *
 * @author djz
 **/
@Data
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 创建者Id
     */
    private Long createUserId;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态
     */
    private Short status;

    @TableField(exist=false)
    private List<Integer> roleIdList;


}
