package com.kpcnc.mydataapi.api.base.gurt.service.impl;

import com.kpcnc.mydataapi.api.base.gurt.models.GurtHistSearch;
import com.kpcnc.mydataapi.api.base.gurt.models.entity.GurtHistEntity;
import com.kpcnc.mydataapi.api.base.gurt.models.form.GurtHistForm;
import com.kpcnc.mydataapi.api.base.gurt.repository.GurtHistMapper;
import com.kpcnc.mydataapi.api.base.gurt.service.GurtHistService;
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
public class GurtHistServiceImpl implements GurtHistService {
    @Autowired
    GurtHistMapper gurtHistMapper;

    @Override
    public GurtHistEntity regGurtHist(GurtHistForm dom) {
        gurtHistMapper.insertGurtHist(dom.getEntity());
        return gurtHistMapper.selectGurtHist(new GurtHistSearch(dom));
    }

    @Override
    public GurtHistEntity modGurtHist(GurtHistForm dom) {
        gurtHistMapper.updateGurtHist(dom.getEntity());
        return gurtHistMapper.selectGurtHist(new GurtHistSearch(dom));
    }

    @Override
    public void delGurtHist(GurtHistForm dom) {
        gurtHistMapper.deleteGurtHist(dom.getEntity());
        return;
    }

    @Override
    public GurtHistEntity getGurtHist(GurtHistSearch dom) {
        return gurtHistMapper.selectGurtHist(dom);
    }

    @Override
    public ResultListDto<GurtHistEntity> getGurtHistList(GurtHistSearch dom) {
        ResultListDto<GurtHistEntity> result = new ResultListDto<>();
        Long totalCnt = gurtHistMapper.selectGurtHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<GurtHistEntity> list = gurtHistMapper.selectGurtHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
