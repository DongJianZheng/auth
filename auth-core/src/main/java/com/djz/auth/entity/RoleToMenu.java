package com.djz.auth.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色菜单表
 * @author djz
 */
@Data
@TableName("tb_role_to_menu")
public class RoleToMenu extends Model<RoleToMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer roleToMenuId;

    /**
     * 角色代号
     */
    private String roleCode;

    /**
     * 菜单代号,规范权限标识
     */
    private String menuCode;

    @Override
    protected Serializable pkVal() {
        return this.roleToMenuId;
    }

}
