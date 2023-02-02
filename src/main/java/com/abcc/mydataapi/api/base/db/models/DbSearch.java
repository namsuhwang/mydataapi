package com.abcc.mydataapi.api.base.db.models;

import com.abcc.mydataapi.common.models.dto.SearchDto;
import com.abcc.mydataapi.api.base.db.models.entity.DbEntity;
import com.abcc.mydataapi.api.base.db.models.form.DbForm;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
