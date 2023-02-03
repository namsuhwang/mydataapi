package com.albee.mydataapi.api.base.gurt.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.gurt.models.GurtHistSearch;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtHistEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtHistForm;
import com.albee.mydataapi.api.base.gurt.repository.GurtHistMapper;
import com.albee.mydataapi.api.base.gurt.service.GurtHistService;
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
    public void regGurtHist(GurtHistForm dom) {
        gurtHistMapper.insertGurtHist(dom.getEntity());
    }

    @Override
    public void updGurtHist(GurtHistForm dom) {
        gurtHistMapper.updateGurtHist(dom.getEntity());
    }

    @Override
    public void modGurtHist(GurtHistForm dom) {
        if(getGurtHist(new GurtHistSearch(dom)) == null){
            regGurtHist(dom);
        }else{
            updGurtHist(dom);
        }
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
    public GurtHistEntity getGurtHistLast(GurtHistSearch dom) {
        return gurtHistMapper.selectGurtHistLast(dom);
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
