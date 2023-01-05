package com.kpcnc.mydataapi.common.exception;

import com.kpcnc.mydataapi.api.member.models.common.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MyDataApiException extends RuntimeException{
    private ErrorCode errorCode;

    public MyDataApiException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public MyDataApiException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
