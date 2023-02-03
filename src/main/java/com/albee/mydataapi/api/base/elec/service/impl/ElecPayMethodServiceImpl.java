package com.albee.mydataapi.api.base.elec.service.impl;

import com.albee.mydataapi.api.base.elec.service.ElecPayMethodService;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPayMethodSearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPayMethodEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPayMethodForm;
import com.albee.mydataapi.api.base.elec.repository.ElecPayMethodMapper;
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
public class ElecPayMethodServiceImpl implements ElecPayMethodService {
    @Autowired
    ElecPayMethodMapper elecPayMethodMapper;

    @Override
    public void regElecPayMethod(ElecPayMethodForm dom) {
        elecPayMethodMapper.insertElecPayMethod(dom.getEntity());
    }

    @Override
    public void updElecPayMethod(ElecPayMethodForm dom) {
        elecPayMethodMapper.updateElecPayMethod(dom.getEntity());
    }

    @Override
    public void modElecPayMethod(ElecPayMethodForm dom) {
        if(getElecPayMethod(new ElecPayMethodSearch(dom)) == null){
            regElecPayMethod(dom);
        }else{
            updElecPayMethod(dom);
        }
    }

    @Override
    public void delElecPayMethod(ElecPayMethodForm dom) {
        elecPayMethodMapper.deleteElecPayMethod(dom.getEntity());
        return;
    }

    @Override
    public void allDelElecPayMethod(ElecPayMethodForm dom) {
        elecPayMethodMapper.deleteAllElecPayMethod(dom.getEntity());
        return;
    }


    @Override
    public ElecPayMethodEntity getElecPayMethod(ElecPayMethodSearch dom) {
        return elecPayMethodMapper.selectElecPayMethod(dom);
    }

    @Override
    public ElecPayMethodEntity getElecPayMethodLast(ElecPayMethodSearch dom) {
        return elecPayMethodMapper.selectElecPayMethodLast(dom);
    }

    @Override
    public ResultListDto<ElecPayMethodEntity> getElecPayMethodList(ElecPayMethodSearch dom) {
        ResultListDto<ElecPayMethodEntity> result = new ResultListDto<>();
        Long totalCnt = elecPayMethodMapper.selectElecPayMethodListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ElecPayMethodEntity> list = elecPayMethodMapper.selectElecPayMethodList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}