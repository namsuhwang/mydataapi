package com.kpcnc.mydataapi.models.common.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeDto {
  private String divCode;
  private String code;
  private String codeName;
  private String codeDesc;
  private Integer order;
  private String useYn;
}
