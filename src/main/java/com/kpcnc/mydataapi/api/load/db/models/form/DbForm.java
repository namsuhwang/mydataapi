package com.kpcnc.mydataapi.api.load.db.models.form;

import com.kpcnc.mydataapi.api.load.db.models.entity.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DbForm{
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String isRunningPension;    // 보유여부
    private String regUserId;    // 등록자
    private String regDt;    // 등록일시
    private String chgUserId;    // 수정자
    private String chgDt;    // 수정일시

    public DbEntity getEntity(){
        DbEntity entity = new DbEntity();
        entity.setMemberId(memberId);
        entity.setOrgCd(orgCd);
        entity.setIsRunningPension(isRunningPension);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
