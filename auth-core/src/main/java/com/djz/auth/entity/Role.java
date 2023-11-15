package com.djz.auth.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色表
 * @author djz
 */
@Builder
@Data
@TableName("tb_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;


    /**
     * 角色代号主键
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;


    @Override
    protected Serializable pkVal() {
        return this.roleCode;
    }

}
