package com.kpcnc.mydataapi.common.models.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CommonCodeEntity {
    private String divCode;
    private String code;
    private String codeName;
    private String codeDesc;
    private Integer order;
    private String useYn;
}
