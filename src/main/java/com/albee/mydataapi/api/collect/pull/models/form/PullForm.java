package com.albee.mydataapi.api.collect.pull.models.form;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PullForm {
    private String memberId;    // 회원ID

    private String requestType;    // 조회 구분. 0:자산 목록 조회. 전송요구 설정된 . 1:고객선택자산 요청

}
