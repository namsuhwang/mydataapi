package com.albee.mydataapi.api.common.trans.models.dto;


import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustJoinCheck extends ResBaseDto {
    private String servicId;
    private String userCi;
    private Boolean isJoin;

    public HashMap<String, Object> getCustJoinCheckResult(){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("rsp_code", getRspCode());
        resultMap.put("rsp_msg", getRspMsg());
        resultMap.put("is_join", isJoin);
        return resultMap;
    }
}
