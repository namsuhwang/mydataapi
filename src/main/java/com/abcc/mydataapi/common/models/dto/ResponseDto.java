package com.abcc.mydataapi.common.models.dto;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
public class ResponseDto<D> {
    private String code;
    private String message;
    private D data;


    public ResponseDto(String code, String message, D data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseDto(D data) {
        this.data = data;
    }
}
