package com.albee.mydataapi.api.base.elec.service.impl;

import com.albee.mydataapi.api.base.elec.models.ElecPayHistSearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPayHistEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPayHistForm;
import com.albee.mydataapi.api.base.elec.repository.ElecPayHistMapper;
import com.albee.mydataapi.api.base.elec.service.ElecPayHistService;
import com.albee.mydataapi.common.models.dto.ResultListDto;
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
public class ElecPayHistServiceImpl implements ElecPayHistService {
    @Autowired
    ElecPayHistMapper elecPayHistMapper;

    @Override
    public void regElecPayHist(ElecPayHistForm dom) {
        elecPayHistMapper.insertElecPayHist(dom.getEntity());
    }

    @Override
    public void updElecPayHist(ElecPayHistForm dom) {
        elecPayHistMapper.updateElecPayHist(dom.getEntity());
    }

    @Override
    public void modElecPayHist(ElecPayHistForm dom) {
        if(getElecPayHist(new ElecPayHistSearch(dom)) == null){
            regElecPayHist(dom);
        }else{
            updElecPayHist(dom);
        }
    }

    @Override
    public void delElecPayHist(ElecPayHistForm dom) {
        elecPayHistMapper.deleteElecPayHist(dom.getEntity());
        return;
    }

    @Override
    public ElecPayHistEntity getElecPayHist(ElecPayHistSearch dom) {
        return elecPayHistMapper.selectElecPayHist(dom);
    }

    @Override
    public ElecPayHistEntity getElecPayHistLast(ElecPayHistSearch dom) {
        return elecPayHistMapper.selectElecPayHistLast(dom);
    }

    @Override
    public ResultListDto<ElecPayHistEntity> getElecPayHistList(ElecPayHistSearch dom) {
        ResultListDto<ElecPayHistEntity> result = new ResultListDto<>();
        Long totalCnt = elecPayHistMapper.selectElecPayHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ElecPayHistEntity> list = elecPayHistMapper.selectElecPayHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
