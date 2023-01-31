package com.kpcnc.mydataapi.common.models.form;


import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeForm {
  private String divCode;
  private String code;
  private String codeName;
  private String codeDesc;
  private Integer order;
  private String useYn;
}
