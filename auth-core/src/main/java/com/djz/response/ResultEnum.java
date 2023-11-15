package com.djz.response;


import com.djz.handler.MessageSourceHandler;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.EnumSet;

public enum ResultEnum {

    SUCCESS(200, "framework.success"),
    EXCEPTION(501, "framework.exception");

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应消息
     */
    private String message;

    @Setter
    private MessageSourceHandler messageSourceHandler;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取响应码
     * @return int
     */
    public int getCode() {
        return code;
    }

    /**
     * 获取响应消息
     * @return String
     */
    public String getMessage() {
        return messageSourceHandler.getMessage(message);
    }

    /**
     * 通过静态内部类的方式注入bean，并赋值到枚举中
     */
    @Component
    public static class ReportTypeServiceInjector {
        // 引入国际化处理类
        @Resource
        private MessageSourceHandler messageSourceHandler;

        @PostConstruct
        public void postConstruct() {
            for (ResultEnum resp : EnumSet.allOf(ResultEnum.class)) {
                resp.setMessageSourceHandler(messageSourceHandler);
            }
        }
    }
}
