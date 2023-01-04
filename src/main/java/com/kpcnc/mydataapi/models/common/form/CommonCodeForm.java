package com.kpcnc.mydataapi.models.common.form;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
