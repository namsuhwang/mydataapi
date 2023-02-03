package com.albee.mydataapi.api.common.gateway.models.res.gurt;

import com.albee.mydataapi.api.base.gurt.models.form.GurtBaseForm;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.gateway.models.res.ResBaseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Gurt003ResDto extends ResBaseDto {

    @JsonProperty("trans_cnt")
    private Integer listCnt;

    @JsonProperty("trans_list")
    private List<Gurt003ResDetailDto> list;
}
