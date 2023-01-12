package com.kpcnc.mydataapi.api.load.elec.service.impl;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPpayAccSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayAccEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayAccForm;
import com.kpcnc.mydataapi.api.load.elec.repository.ElecPpayAccMapper;
import com.kpcnc.mydataapi.api.load.elec.service.ElecPpayAccService;
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
public class ElecPpayAccServiceImpl implements ElecPpayAccService {
    @Autowired
    ElecPpayAccMapper elecPpayAccMapper;

    @Override
    public ElecPpayAccEntity regElecPpayAcc(ElecPpayAccForm dom) {
        elecPpayAccMapper.insertElecPpayAcc(dom.getEntity());
        return elecPpayAccMapper.selectElecPpayAcc(new ElecPpayAccSearch(dom));
    }

    @Override
    public ElecPpayAccEntity modElecPpayAcc(ElecPpayAccForm dom) {
        elecPpayAccMapper.updateElecPpayAcc(dom.getEntity());
        return elecPpayAccMapper.selectElecPpayAcc(new ElecPpayAccSearch(dom));
    }

    @Override
    public void delElecPpayAcc(ElecPpayAccForm dom) {
        elecPpayAccMapper.deleteElecPpayAcc(dom.getEntity());
        return;
    }

    @Override
    public ElecPpayAccEntity getElecPpayAcc(ElecPpayAccSearch dom) {
        return elecPpayAccMapper.selectElecPpayAcc(dom);
    }

    @Override
    public ResultListDto<ElecPpayAccEntity> getElecPpayAccList(ElecPpayAccSearch dom) {
        ResultListDto<ElecPpayAccEntity> result = new ResultListDto<>();
        Long totalCnt = elecPpayAccMapper.selectElecPpayAccListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ElecPpayAccEntity> list = elecPpayAccMapper.selectElecPpayAccList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
