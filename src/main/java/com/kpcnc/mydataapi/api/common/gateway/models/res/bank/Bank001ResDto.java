package com.kpcnc.mydataapi.api.common.gateway.models.res.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Bank001ResDto extends ResBaseDto {

    private String regDate;

    @JsonProperty("account_cnt")
    private Integer listCnt;

    @JsonProperty("account_list")
    private List<Bank001ResDetailDto> list;

}