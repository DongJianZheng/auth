package com.djz.auth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户电话关系表
 * @author djz
 */
@Data
@TableName("tb_info_to_user")
public class InfoToUser extends Model<InfoToUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private String id;

    /**
     * 用户账号
     */
    private String identityInfo;
    /**
     * 用户主键
     */
    private String userNo;

    /**
     * 登录类型:0 用户名登录 1手机登录 2 邮箱登录
     */
    private Integer identityType;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
