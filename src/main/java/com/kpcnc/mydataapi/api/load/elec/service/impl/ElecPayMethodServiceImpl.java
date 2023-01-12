package com.kpcnc.mydataapi.api.load.elec.service.impl;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPayMethodSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPayMethodEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPayMethodForm;
import com.kpcnc.mydataapi.api.load.elec.repository.ElecPayMethodMapper;
import com.kpcnc.mydataapi.api.load.elec.service.ElecPayMethodService;
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
public class ElecPayMethodServiceImpl implements ElecPayMethodService {
    @Autowired
    ElecPayMethodMapper elecPayMethodMapper;

    @Override
    public ElecPayMethodEntity regElecPayMethod(ElecPayMethodForm dom) {
        elecPayMethodMapper.insertElecPayMethod(dom.getEntity());
        return elecPayMethodMapper.selectElecPayMethod(new ElecPayMethodSearch(dom));
    }

    @Override
    public ElecPayMethodEntity modElecPayMethod(ElecPayMethodForm dom) {
        elecPayMethodMapper.updateElecPayMethod(dom.getEntity());
        return elecPayMethodMapper.selectElecPayMethod(new ElecPayMethodSearch(dom));
    }

    @Override
    public void delElecPayMethod(ElecPayMethodForm dom) {
        elecPayMethodMapper.deleteElecPayMethod(dom.getEntity());
        return;
    }

    @Override
    public ElecPayMethodEntity getElecPayMethod(ElecPayMethodSearch dom) {
        return elecPayMethodMapper.selectElecPayMethod(dom);
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