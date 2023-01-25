package com.kpcnc.mydataapi.api.common.gateway.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiCallCycleResDetailDto {
    private List<Object> list;
}
