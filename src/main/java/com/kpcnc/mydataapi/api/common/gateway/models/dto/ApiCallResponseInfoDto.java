package com.kpcnc.mydataapi.api.common.gateway.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiCallResponseInfoDto {
    private Long searchTimeStamp;
    private String nextPage;
    // private List<HashMap<String, Object>> list;
    private String resultJson;
    private Object data;
}
