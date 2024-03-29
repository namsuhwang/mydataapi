package com.albee.mydataapi.api.base.elec.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPpaySearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayForm;
import com.albee.mydataapi.api.base.elec.repository.ElecPpayMapper;
import com.albee.mydataapi.api.base.elec.service.ElecPpayService;
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
public class ElecPpayServiceImpl implements ElecPpayService {
    @Autowired
    ElecPpayMapper elecPpayMapper;

    @Override
    public void regElecPpay(ElecPpayForm dom) {
        elecPpayMapper.insertElecPpay(dom.getEntity());
    }

    @Override
    public void updElecPpay(ElecPpayForm dom) {
        elecPpayMapper.updateElecPpay(dom.getEntity());
    }

    @Override
    public void modElecPpay(ElecPpayForm dom) {
        if(getElecPpay(new ElecPpaySearch(dom)) == null){
            regElecPpay(dom);
        }else{
            updElecPpay(dom);
        }
    }

    @Override
    public void delElecPpay(ElecPpayForm dom) {
        elecPpayMapper.deleteElecPpay(dom.getEntity());
        return;
    }

    @Override
    public void allDelElecPpay(ElecPpayForm dom) {
        elecPpayMapper.deleteAllElecPpay(dom.getEntity());
        return;
    }

    @Override
    public ElecPpayEntity getElecPpay(ElecPpaySearch dom) {
        return elecPpayMapper.selectElecPpay(dom);
    }

    @Override
    public ResultListDto<ElecPpayEntity> getElecPpayList(ElecPpaySearch dom) {
        ResultListDto<ElecPpayEntity> result = new ResultListDto<>();
        Long totalCnt = elecPpayMapper.selectElecPpayListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ElecPpayEntity> list = elecPpayMapper.selectElecPpayList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
