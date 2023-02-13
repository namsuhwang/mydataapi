package com.albee.mydataapi.api.base.db.models;

import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.base.db.models.entity.DbEntity;
import com.albee.mydataapi.api.base.db.models.form.DbForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class DbSearch extends SearchDto {
    private String isRunningPension;    // 보유여부

    public DbSearch(String memberId, String orgCd) {
        super(memberId, orgCd);
    }

    public DbSearch(String memberId, String orgCd, String isRunningPension) {
        super(memberId, orgCd);
        this.isRunningPension = isRunningPension;
    }

    public DbSearch(DbEntity entity) {
        super(entity.getMemberId(), entity.getOrgCd());
        this.isRunningPension = entity.getIsRunningPension();
    }

    public DbSearch(DbForm form) {
        super(form.getMemberId(), form.getOrgCd());
        this.isRunningPension = form.getIsRunningPension();
    }
}
