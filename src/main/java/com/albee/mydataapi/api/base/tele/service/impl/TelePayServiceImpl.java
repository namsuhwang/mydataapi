package com.albee.mydataapi.api.base.tele.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.tele.models.TelePaySearch;
import com.albee.mydataapi.api.base.tele.models.entity.TelePayEntity;
import com.albee.mydataapi.api.base.tele.models.form.TelePayForm;
import com.albee.mydataapi.api.base.tele.repository.TelePayMapper;
import com.albee.mydataapi.api.base.tele.service.TelePayService;
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
public class TelePayServiceImpl implements TelePayService {
    @Autowired
    TelePayMapper telePayMapper;

    @Override
    public void regTelePay(TelePayForm dom) {
        telePayMapper.insertTelePay(dom.getEntity());
    }

    @Override
    public void updTelePay(TelePayForm dom) {
        telePayMapper.updateTelePay(dom.getEntity());
    }

    @Override
    public void modTelePay(TelePayForm dom) {
        if(getTelePay(new TelePaySearch(dom)) == null){
            regTelePay(dom);
        }else{
            updTelePay(dom);
        }
    }

    @Override
    public void delTelePay(TelePayForm dom) {
        telePayMapper.deleteTelePay(dom.getEntity());
        return;
    }

    @Override
    public TelePayEntity getTelePay(TelePaySearch dom) {
        return telePayMapper.selectTelePay(dom);
    }

    @Override
    public TelePayEntity getTelePayLast(TelePaySearch dom) {
        return telePayMapper.selectTelePayLast(dom);
    }

    @Override
    public ResultListDto<TelePayEntity> getTelePayList(TelePaySearch dom) {
        ResultListDto<TelePayEntity> result = new ResultListDto<>();
        Long totalCnt = telePayMapper.selectTelePayListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<TelePayEntity> list = telePayMapper.selectTelePayList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
