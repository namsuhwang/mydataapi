package com.albee.mydataapi.common.models.dto;

import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultListDto<D> {
    private Long totalCnt;

    private Integer currentPage;

    private Integer pageCnt;

    private List<D> list;

}
