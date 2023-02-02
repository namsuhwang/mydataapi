package com.albee.mydataapi.api.common.member.models.member;

import com.albee.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.albee.mydataapi.api.common.member.models.member.form.MemberTokenForm;
import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class MemberTokenSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private Integer sendReqSeq;    // 전송요구 일련번호
    private String currentDt;   // 접근토큰 만료 일시 체크
    private String fpSendReqYn;    // 정기전송 요청 여부

    private String currentDay;   // 정기전송 기간 유효 체크

    public MemberTokenSearch(String memberId, String orgCd, Integer sendReqSeq) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.sendReqSeq = sendReqSeq;
    }

    public MemberTokenSearch(MemberTokenEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.sendReqSeq = entity.getSendReqSeq();
    }

    public MemberTokenSearch(MemberTokenForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.sendReqSeq = form.getSendReqSeq();
    }
}
