package com.kpcnc.mydataapi.api.common.gateway.models.res.irp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kpcnc.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.kpcnc.mydataapi.api.common.gateway.models.res.bank.Bank001ResDetailDto;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Irp001ResDto extends ResBaseDto {

    @JsonProperty("irp_cnt")
    private Integer listCnt;

    @JsonProperty("irp_list")
    private List<Irp001ResDetailDto> list;

}