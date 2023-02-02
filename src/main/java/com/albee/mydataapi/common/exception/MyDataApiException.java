package com.albee.mydataapi.common.exception;

import com.albee.mydataapi.common.models.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MyDataApiException extends RuntimeException{
    private ErrorCode errorCode;

    public MyDataApiException(ErrorCode errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public MyDataApiException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
