package com.albee.mydataapi.api.base.db.service;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.db.models.DbSearch;
import com.albee.mydataapi.api.base.db.models.entity.DbEntity;
import com.albee.mydataapi.api.base.db.models.form.DbForm;

public interface DbService{
    public DbEntity regDb(DbForm dom);

    public DbEntity modDb(DbForm dom);

    public void  delDb(DbForm dom);

    public DbEntity getDb(DbSearch dom);

    public ResultListDto<DbEntity> getDbList(DbSearch dom);
}
