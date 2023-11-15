package com.djz.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单表
 * @author djz
 */
@Data
@TableName("tb_menu")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;
    /**
     * 菜单代号,规范权限标识
     */
    private String menuCode;
    /**
     * 父菜单主键
     */
    private String parentId;

    private String menuId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单类型，0：菜单  `：业务按钮
     */
    private Short menuType;

    /**
     * 菜单的序号
     */
    private Integer num;

    /**
     * 菜单地址
     */
    private String url;

    private String icon;

    @TableField(exist = false)
    private List<Menu> childMenu;

    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }

}
