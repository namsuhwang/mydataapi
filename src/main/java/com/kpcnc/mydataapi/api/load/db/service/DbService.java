package com.kpcnc.mydataapi.api.load.db.service;

import com.kpcnc.mydataapi.api.load.db.models.DbSearch;
import com.kpcnc.mydataapi.api.load.db.models.entity.DbEntity;
import com.kpcnc.mydataapi.api.load.db.models.form.DbForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface DbService{
    public DbEntity regDb(DbForm dom);

    public DbEntity modDb(DbForm dom);

    public void  delDb(DbForm dom);

    public DbEntity getDb(DbSearch dom);

    public ResultListDto<DbEntity> getDbList(DbSearch dom);
}
