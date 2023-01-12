package com.kpcnc.mydataapi.api.load.db.models;

import com.kpcnc.mydataapi.api.load.db.models.entity.DbEntity;
import com.kpcnc.mydataapi.api.load.db.models.form.DbForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class DbSearch extends SearchDto {
    private String memberId;    // 회원ID
    private String orgCd;    // 기관코드
    private String isRunningPension;    // 보유여부

    public DbSearch(String memberId, String orgCd, String isRunningPension) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.isRunningPension = isRunningPension;
    }

    public DbSearch(DbEntity entity) {
        this.memberId = entity.getMemberId();
        this.orgCd = entity.getOrgCd();
        this.isRunningPension = entity.getIsRunningPension();
    }

    public DbSearch(DbForm form) {
        this.memberId = form.getMemberId();
        this.orgCd = form.getOrgCd();
        this.isRunningPension = form.getIsRunningPension();
    }
}
