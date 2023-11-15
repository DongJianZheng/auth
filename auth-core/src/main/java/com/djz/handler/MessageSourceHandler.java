package com.djz.handler;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class MessageSourceHandler {


    @Resource
    private MessageSource messageSource;


    public String getMessage(String message) {
        return this.getMessage(message, null, message);
    }

    public String getMessage(String message, Object[] args) {
        return this.getMessage(message, args, message);
    }

    public String getMessage(String message, Object[] args, String defaultMessage) {
        return messageSource.getMessage(message, args, defaultMessage, LocaleContextHolder.getLocale());
    }
}
