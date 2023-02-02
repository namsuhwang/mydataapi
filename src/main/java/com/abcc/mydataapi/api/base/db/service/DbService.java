package com.abcc.mydataapi.api.base.db.service;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.db.models.DbSearch;
import com.abcc.mydataapi.api.base.db.models.entity.DbEntity;
import com.abcc.mydataapi.api.base.db.models.form.DbForm;

public interface DbService{
    public DbEntity regDb(DbForm dom);

    public DbEntity modDb(DbForm dom);

    public void  delDb(DbForm dom);

    public DbEntity getDb(DbSearch dom);

    public ResultListDto<DbEntity> getDbList(DbSearch dom);
}
