package com.albee.mydataapi.api.base.elec.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecAccSearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecAccEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecAccForm;
import com.albee.mydataapi.api.base.elec.repository.ElecAccMapper;
import com.albee.mydataapi.api.base.elec.service.ElecAccService;
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
public class ElecAccServiceImpl implements ElecAccService {
    @Autowired
    ElecAccMapper elecAccMapper;

    @Override
    public void regElecAcc(ElecAccForm dom) {
        elecAccMapper.insertElecAcc(dom.getEntity());
    }

    @Override
    public void updElecAcc(ElecAccForm dom) {
        elecAccMapper.updateElecAcc(dom.getEntity());
    }

    @Override
    public void modElecAcc(ElecAccForm dom) {
        if(getElecAcc(new ElecAccSearch(dom)) == null){
            regElecAcc(dom);
        }else{
            updElecAcc(dom);
        }
    }

    @Override
    public void delElecAcc(ElecAccForm dom) {
        elecAccMapper.deleteElecAcc(dom.getEntity());
        return;
    }

    @Override
    public ElecAccEntity getElecAcc(ElecAccSearch dom) {
        return elecAccMapper.selectElecAcc(dom);
    }

    @Override
    public ResultListDto<ElecAccEntity> getElecAccList(ElecAccSearch dom) {
        ResultListDto<ElecAccEntity> result = new ResultListDto<>();
        Long totalCnt = elecAccMapper.selectElecAccListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ElecAccEntity> list = elecAccMapper.selectElecAccList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
