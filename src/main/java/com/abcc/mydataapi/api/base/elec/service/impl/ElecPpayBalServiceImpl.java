package com.abcc.mydataapi.api.base.elec.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.elec.models.ElecPpayBalSearch;
import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayBalEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPpayBalForm;
import com.abcc.mydataapi.api.base.elec.repository.ElecPpayBalMapper;
import com.abcc.mydataapi.api.base.elec.service.ElecPpayBalService;
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
public class ElecPpayBalServiceImpl implements ElecPpayBalService {
    @Autowired
    ElecPpayBalMapper elecPpayBalMapper;

    @Override
    public ElecPpayBalEntity regElecPpayBal(ElecPpayBalForm dom) {
        elecPpayBalMapper.insertElecPpayBal(dom.getEntity());
        return elecPpayBalMapper.selectElecPpayBal(new ElecPpayBalSearch(dom));
    }

    @Override
    public ElecPpayBalEntity modElecPpayBal(ElecPpayBalForm dom) {
        elecPpayBalMapper.updateElecPpayBal(dom.getEntity());
        return elecPpayBalMapper.selectElecPpayBal(new ElecPpayBalSearch(dom));
    }

    @Override
    public void delElecPpayBal(ElecPpayBalForm dom) {
        elecPpayBalMapper.deleteElecPpayBal(dom.getEntity());
        return;
    }

    @Override
    public ElecPpayBalEntity getElecPpayBal(ElecPpayBalSearch dom) {
        return elecPpayBalMapper.selectElecPpayBal(dom);
    }

    @Override
    public ResultListDto<ElecPpayBalEntity> getElecPpayBalList(ElecPpayBalSearch dom) {
        ResultListDto<ElecPpayBalEntity> result = new ResultListDto<>();
        Long totalCnt = elecPpayBalMapper.selectElecPpayBalListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ElecPpayBalEntity> list = elecPpayBalMapper.selectElecPpayBalList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
