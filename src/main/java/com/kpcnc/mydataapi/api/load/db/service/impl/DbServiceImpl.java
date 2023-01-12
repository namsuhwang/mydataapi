package com.kpcnc.mydataapi.api.load.db.service.impl;

import com.kpcnc.mydataapi.api.load.db.models.DbSearch;
import com.kpcnc.mydataapi.api.load.db.models.entity.DbEntity;
import com.kpcnc.mydataapi.api.load.db.models.form.DbForm;
import com.kpcnc.mydataapi.api.load.db.repository.DbMapper;
import com.kpcnc.mydataapi.api.load.db.service.DbService;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class DbServiceImpl implements DbService {
    @Autowired
    DbMapper dbMapper;

    @Override
    public DbEntity regDb(DbForm dom) {
        dbMapper.insertDb(dom.getEntity());
        return dbMapper.selectDb(new DbSearch(dom));
    }

    @Override
    public DbEntity modDb(DbForm dom) {
        dbMapper.updateDb(dom.getEntity());
        return dbMapper.selectDb(new DbSearch(dom));
    }

    @Override
    public void delDb(DbForm dom) {
        dbMapper.deleteDb(dom.getEntity());
        return;
    }

    @Override
    public DbEntity getDb(DbSearch dom) {
        return dbMapper.selectDb(dom);
    }

    @Override
    public ResultListDto<DbEntity> getDbList(DbSearch dom) {
        ResultListDto<DbEntity> result = new ResultListDto<>();
        Long totalCnt = dbMapper.selectDbListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<DbEntity> list = dbMapper.selectDbList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
