package com.kpcnc.mydataapi.api.load.elec.service.impl;

import com.kpcnc.mydataapi.api.load.elec.models.ElecAccSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecAccEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecAccForm;
import com.kpcnc.mydataapi.api.load.elec.repository.ElecAccMapper;
import com.kpcnc.mydataapi.api.load.elec.service.ElecAccService;
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
public class ElecAccServiceImpl implements ElecAccService {
    @Autowired
    ElecAccMapper elecAccMapper;

    @Override
    public ElecAccEntity regElecAcc(ElecAccForm dom) {
        elecAccMapper.insertElecAcc(dom.getEntity());
        return elecAccMapper.selectElecAcc(new ElecAccSearch(dom));
    }

    @Override
    public ElecAccEntity modElecAcc(ElecAccForm dom) {
        elecAccMapper.updateElecAcc(dom.getEntity());
        return elecAccMapper.selectElecAcc(new ElecAccSearch(dom));
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
