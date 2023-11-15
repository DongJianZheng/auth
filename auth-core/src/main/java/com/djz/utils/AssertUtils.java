package com.djz.utils;

import cn.hutool.core.text.CharSequenceUtil;
import com.djz.enums.MessageEnum;
import com.djz.exception.BusinessException;


/**
 * 本工具最初目的是减少手写if判断，为了结合更好的业务操作，添加异常类，然后全局异常管理。
 * @author djz
 */
public class AssertUtils {

    public static void notNull(final Object object, final String name) {
        if (object == null) {
            throw new BusinessException(MessageEnum.EM1_PARAM_NOT_NULL.getResCode(), name + " 不能为空");
        }
    }

    public static void notEmpty(final CharSequence s, final String name) {
        if (CharSequenceUtil.isEmpty(s)) {
            throw new BusinessException(MessageEnum.EM1_PARAM_NOT_NULL.getResCode(), name + " 不能为空或者长度为0");
        }
    }

    public static void notBlank(final CharSequence s, final String name) {
        if (CharSequenceUtil.isBlank(s)) {
            throw new BusinessException(MessageEnum.EM1_PARAM_NOT_NULL.getResCode(), name + " 必须有实际字符");
        }
    }

    public static void notNull(final Object object, final int code, String msg) {
        if (object == null) {
            throw new BusinessException(code, msg);
        }
    }

    public static void notEmpty(final CharSequence s, final int code, String msg) {
        if (CharSequenceUtil.isEmpty(s)) {
            throw new BusinessException(code, msg);
        }
    }


    public static void notBlank(final CharSequence s, final int code, String msg) {
        if (CharSequenceUtil.isBlank(s)) {
            throw new BusinessException(code, msg);
        }
    }
}
