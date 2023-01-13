package com.kpcnc.mydataapi.api.load.tele.models.form;

import com.kpcnc.mydataapi.api.load.tele.models.entity.TeleContEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeleContForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String mgmtId;    // 계약관리번호
    private String isConsent;    // 전송요구 여부
    private String telecomNum;    // 가입번호
    private String type;    // 통신구분 (코드)
    private String status;    // 가입구분 (코드)
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public TeleContEntity getEntity(){
        TeleContEntity entity = new TeleContEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setMgmtId(mgmtId);
        entity.setIsConsent(isConsent);
        entity.setTelecomNum(telecomNum);
        entity.setType(type);
        entity.setStatus(status);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
