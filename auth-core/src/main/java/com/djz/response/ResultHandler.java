package com.djz.response;


import cn.hutool.extra.spring.SpringUtil;
import com.djz.handler.MessageSourceHandler;

/**
 * @author djz
 */
public class ResultHandler {

    private ResultHandler(){}

    private static final MessageSourceHandler MESSAGE_SOURCE_HANDLER = SpringUtil.getBean(MessageSourceHandler.class);

    /**
     * 成功时生成ResultBean对象
     * @return ResultBean
     */
    public static ResultBean ok() {
        return new ResultBean(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 成功时生成ResultBean对象
     * @param data 数据
     * @return ResultBean
     */
    public static ResultBean ok(Object data) {
        return new ResultBean(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功时生成ResultBean对象
     * @param data 数据
     * @param message 消息
     * @return ResultBean
     */
    public static ResultBean ok(Object data, String message) {
        return new ResultBean(ResultEnum.SUCCESS.getCode(), MESSAGE_SOURCE_HANDLER.getMessage(message), data);
    }


    /**
     * 成功时生成ResultBean对象
     * @param data 数据
     * @param message 消息
     * @return ResultBean
     */
    public static ResultBean ok(Object data, String message, Object... msgData) {
        return new ResultBean(ResultEnum.SUCCESS.getCode(), MESSAGE_SOURCE_HANDLER.getMessage(message, msgData), data);
    }


    /**
     * 成功时生成ResultBean对象
     * @param message 消息
     * @return ResultBean
     */
    public static ResultBean okMsg(String message) {
        return new ResultBean(ResultEnum.SUCCESS.getCode(), MESSAGE_SOURCE_HANDLER.getMessage(message), null);
    }

    /**
     * 成功时生成ResultBean对象
     * @param message 消息
     * @return ResultBean
     */
    public static ResultBean okMsg(String message, Object... msgData) {
        return new ResultBean(ResultEnum.SUCCESS.getCode(), MESSAGE_SOURCE_HANDLER.getMessage(message, msgData), null);
    }


    /**
     * 失败时生成ResultBean对象
     * @return ResultBean
     */
    public static ResultBean error() {
        return new ResultBean(ResultEnum.EXCEPTION.getCode(), ResultEnum.EXCEPTION.getMessage(), null);
    }

    /**
     * 失败时生成ResultBean对象
     * @param error  错误类型
     * @return  ResultBean
     */
    public static ResultBean error(ResultEnum error) {
        return new ResultBean(error.getCode(), error.getMessage(), null);
    }

    /**
     * 失败时生成ResultBean对象
     * @param message 消息
     * @return ResultBean
     */
    public static ResultBean error(String message) {
        return new ResultBean(ResultEnum.EXCEPTION.getCode(), MESSAGE_SOURCE_HANDLER.getMessage(message), null);
    }

    /**
     * @param message 消息
     * @return ResultBean
     */
    public static ResultBean resultBean(Integer code, String message) {
        return new ResultBean(code, MESSAGE_SOURCE_HANDLER.getMessage(message), null);
    }

    /**
     * @param message 消息
     * @return ResultBean
     */
    public static ResultBean resultBean(Integer code, String message, Object data) {
        return new ResultBean(code, MESSAGE_SOURCE_HANDLER.getMessage(message), data);
    }
}
