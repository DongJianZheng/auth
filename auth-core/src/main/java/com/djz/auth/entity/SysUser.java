package com.djz.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 用户表
 * @author djz
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@TableName("tb_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    private String id;

    /**
     * 是电话号码，也是账号（登录用）
     */
    private String mobile;
    /**
     * 姓名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     *
     */
    private String email;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态值（1：启用，2：禁用，3：删除）
     */
    private Integer status;

    @TableField(exist = false)
    private String token;

    @TableField(exist = false)
    private String roleName;


}
