package com.abcc.mydataapi.api.base.gurt.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.gurt.models.GurtSearch;
import com.abcc.mydataapi.api.base.gurt.models.entity.GurtEntity;
import com.abcc.mydataapi.api.base.gurt.models.form.GurtForm;
import com.abcc.mydataapi.api.base.gurt.repository.GurtMapper;
import com.abcc.mydataapi.api.base.gurt.service.GurtService;
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
public class GurtServiceImpl implements GurtService {
    @Autowired
    GurtMapper gurtMapper;

    @Override
    public GurtEntity regGurt(GurtForm dom) {
        gurtMapper.insertGurt(dom.getEntity());
        return gurtMapper.selectGurt(new GurtSearch(dom));
    }

    @Override
    public GurtEntity modGurt(GurtForm dom) {
        gurtMapper.updateGurt(dom.getEntity());
        return gurtMapper.selectGurt(new GurtSearch(dom));
    }

    @Override
    public void delGurt(GurtForm dom) {
        gurtMapper.deleteGurt(dom.getEntity());
        return;
    }

    @Override
    public GurtEntity getGurt(GurtSearch dom) {
        return gurtMapper.selectGurt(dom);
    }

    @Override
    public ResultListDto<GurtEntity> getGurtList(GurtSearch dom) {
        ResultListDto<GurtEntity> result = new ResultListDto<>();
        Long totalCnt = gurtMapper.selectGurtListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<GurtEntity> list = gurtMapper.selectGurtList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
