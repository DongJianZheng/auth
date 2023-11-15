package com.djz.exception;

import com.djz.enums.MessageEnum;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -5292750704081267907L;
    private Integer errCode = 501;
    private String errMsg;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    public BusinessException(MessageEnum messageEnum) {
        this.errCode = messageEnum.getResCode();
        this.errMsg = messageEnum.getResMsg();
    }

    public int getErrCode() {
        return this.errCode;
    }
}