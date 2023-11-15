package com.djz.auth.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 登录请求
 * @author djz
 */
@Data
public class LoginRequestVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 身份
     */
    @NotBlank(message = "身份必填！")
    private String identity;

    /**
     * 密码
     */
    @NotBlank(message = "密码必填！")
    private String password;

}
