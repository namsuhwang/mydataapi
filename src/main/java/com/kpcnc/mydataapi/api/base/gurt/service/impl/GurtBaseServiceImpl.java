package com.kpcnc.mydataapi.api.base.gurt.service.impl;

import com.kpcnc.mydataapi.api.base.gurt.models.GurtBaseSearch;
import com.kpcnc.mydataapi.api.base.gurt.models.entity.GurtBaseEntity;
import com.kpcnc.mydataapi.api.base.gurt.models.form.GurtBaseForm;
import com.kpcnc.mydataapi.api.base.gurt.repository.GurtBaseMapper;
import com.kpcnc.mydataapi.api.base.gurt.service.GurtBaseService;
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
public class GurtBaseServiceImpl implements GurtBaseService {
    @Autowired
    GurtBaseMapper gurtBaseMapper;

    @Override
    public GurtBaseEntity regGurtBase(GurtBaseForm dom) {
        gurtBaseMapper.insertGurtBase(dom.getEntity());
        return gurtBaseMapper.selectGurtBase(new GurtBaseSearch(dom));
    }

    @Override
    public GurtBaseEntity modGurtBase(GurtBaseForm dom) {
        gurtBaseMapper.updateGurtBase(dom.getEntity());
        return gurtBaseMapper.selectGurtBase(new GurtBaseSearch(dom));
    }

    @Override
    public void delGurtBase(GurtBaseForm dom) {
        gurtBaseMapper.deleteGurtBase(dom.getEntity());
        return;
    }

    @Override
    public GurtBaseEntity getGurtBase(GurtBaseSearch dom) {
        return gurtBaseMapper.selectGurtBase(dom);
    }

    @Override
    public ResultListDto<GurtBaseEntity> getGurtBaseList(GurtBaseSearch dom) {
        ResultListDto<GurtBaseEntity> result = new ResultListDto<>();
        Long totalCnt = gurtBaseMapper.selectGurtBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<GurtBaseEntity> list = gurtBaseMapper.selectGurtBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
