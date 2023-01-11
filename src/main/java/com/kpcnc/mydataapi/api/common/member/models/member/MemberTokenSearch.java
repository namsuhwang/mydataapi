package com.kpcnc.mydataapi.api.common.member.models.member;

import com.kpcnc.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.kpcnc.mydataapi.api.common.member.models.member.form.MemberTokenForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class MemberTokenSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private Integer sendReqSeq;    // 전송요구 일련번호

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
