package com.djz.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色关系表
 * @author djz
 */
@Data
@TableName("tb_user_to_role")
public class UserToRole extends Model<UserToRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 用户编号
     */
    private String userNo;
    /**
     * 角色代号
     */
    private String roleCode;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
