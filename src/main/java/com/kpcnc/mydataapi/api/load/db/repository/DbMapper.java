package com.kpcnc.mydataapi.api.load.db.repository;

import com.kpcnc.mydataapi.api.load.db.models.DbSearch;
import com.kpcnc.mydataapi.api.load.db.models.entity.DbEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DbMapper{
    int insertDb(DbEntity dom);

    int updateDb(DbEntity dom);

    int deleteDb(DbEntity dom);

    DbEntity selectDb(DbSearch dom);

    Long selectDbListTotalCnt(DbSearch dom);

    List<DbEntity> selectDbList(DbSearch dom);
}
