package com.djz.auth.vo;

import lombok.Data;

/**
 * SysLoginForm
 *
 * @author djz
 * @email 1175639137@qq.com
 * @description 登录表单对象
 */
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;
}
