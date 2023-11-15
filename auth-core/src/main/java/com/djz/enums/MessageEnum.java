package com.djz.enums;

/**
 * @author djz
 */

public enum MessageEnum {
    SYS_SUCCESS(200, "请求成功!"),
    SYS_ERROR(400, "请求失败!"),
    SYS_NOT_FOUND(404, "接口、资源不存在!"),
    SYS_SERVER_ERROR(500, "系统繁忙，请稍候再试!"),
    NOT_PERMISSION(403, "无资源访问权限!"),
    EM1_PARAM_NOT_NULL(1001, "请求参数不能为空!"),
    EM1_ID_NOT_NULL(1002, "ID不能为空!"),
    EM1_USERNAME_NOT_NULL(1003, "用户名不能为空!"),
    EM1_PWD_NOT_NULL(1004, "密码不能为空!"),
    EM1_KAPTCHA_NOT_NULL(1005, "验证码不能为空!"),
    EM1_KAPTCHA_ERROR(1006, "验证码错误!"),
    EM2_TOKEN_NOLEGAL(2001, "当前token无效或过期!"),
    EM2_DATE_NOLEGAL(2002, "日期格式无效!"),
    EM2_REQ_NOLEGAL(2003, "请求参数无效!"),
    EM2_FILE_SIZE_NOLEGAL(2004, "不合法的文件大小!"),
    EM2_SESSION_NOLEGAL(2005, "当前会话无效或过期!"),
    EM3_QUERY_SUCCESS(3001, "查询成功!"),
    EM3_QUERY_ERROR(3002, "查询失败!"),
    EM3_INSERT_SUCCESS(3003, "保存成功!"),
    EM3_INSERT_ERROR(3004, "保存失败!"),
    EM3_DELETE_SUCCESS(3005, "删除成功!"),
    EM3_DELETE_ERROR(3006, "删除失败!"),
    EM3_UPDATE_SUCCESS(3007, "更新成功!"),
    EM3_UPDATE_ERROR(3008, "更新失败!"),
    EM3_BATCH_DELETE_SUCCESS(3009, "批量删除成功!"),
    EM3_BATCH_DELETE_ERROR(3010, "批量删除失败!"),
    EM3_BATCH_INSERT_SUCCESS(3011, "批量添加失败!"),
    EM3_BATCH_UPDATE_SUCCESS(3013, "批量更新成功!"),
    EM3_BATCH_UPDATE_ERROR(3014, "批量更新失败!"),
    EM4_USER_ALREADY_REG(4001, "该用户已经注册!"),
    EM4_NO_THIS_USER(4002, "没有此用户!"),
    EM4_USER_NOT_EXISTED(4003, "没有此用户!"),
    EM4_ACCOUNT_FREEZED(4004, "账号被冻结!"),
    EM4_OLD_PWD_NOT_RIGHT(4005, "原密码不正确!"),
    EM4_TWO_PWD_NOT_MATCH(4006, "两次输入密码不一致!"),
    EM4_USER_PWD_ERROR(4007, "用户名或密码不对!"),
    IDENTIFICATION_ERROR(20001,"身份异常"),
    MSG_ERR(500, "Err"),
    MSG_OK(200, "OK");

    private String resMsg;
    private Integer resCode;

    MessageEnum(int resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }

    public String getResMsg() {
        return this.resMsg;
    }


    public Integer getResCode() {
        return this.resCode;
    }

}