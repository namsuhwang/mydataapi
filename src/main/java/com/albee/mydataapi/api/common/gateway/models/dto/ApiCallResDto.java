package com.albee.mydataapi.api.common.gateway.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiCallResDto<T> {
    private String apiTranDay;
    private String apiTranId;
    private Long searchTimeStamp;
    private String nextPage;
    // private List<HashMap<String, Object>> list;
    private String resultJson;
    private T data;
}
