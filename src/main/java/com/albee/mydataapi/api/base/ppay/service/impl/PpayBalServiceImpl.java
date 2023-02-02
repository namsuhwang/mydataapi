package com.albee.mydataapi.api.base.ppay.service.impl;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import com.albee.mydataapi.api.base.ppay.service.PpayBalService;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.ppay.models.PpayBalSearch;
import com.albee.mydataapi.api.base.ppay.models.form.PpayBalForm;
import com.albee.mydataapi.api.base.ppay.repository.PpayBalMapper;
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
public class PpayBalServiceImpl implements PpayBalService {
    @Autowired
    PpayBalMapper ppayBalMapper;

    @Override
    public PpayBalEntity regPpayBal(PpayBalForm dom) {
        ppayBalMapper.insertPpayBal(dom.getEntity());
        return ppayBalMapper.selectPpayBal(new PpayBalSearch(dom));
    }

    @Override
    public PpayBalEntity modPpayBal(PpayBalForm dom) {
        ppayBalMapper.updatePpayBal(dom.getEntity());
        return ppayBalMapper.selectPpayBal(new PpayBalSearch(dom));
    }

    @Override
    public void delPpayBal(PpayBalForm dom) {
        ppayBalMapper.deletePpayBal(dom.getEntity());
        return;
    }

    @Override
    public PpayBalEntity getPpayBal(PpayBalSearch dom) {
        return ppayBalMapper.selectPpayBal(dom);
    }

    @Override
    public ResultListDto<PpayBalEntity> getPpayBalList(PpayBalSearch dom) {
        ResultListDto<PpayBalEntity> result = new ResultListDto<>();
        Long totalCnt = ppayBalMapper.selectPpayBalListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<PpayBalEntity> list = ppayBalMapper.selectPpayBalList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
