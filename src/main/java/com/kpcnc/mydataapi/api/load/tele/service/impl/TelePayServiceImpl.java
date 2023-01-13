package com.kpcnc.mydataapi.api.load.tele.service.impl;

import com.kpcnc.mydataapi.api.load.tele.models.TelePaySearch;
import com.kpcnc.mydataapi.api.load.tele.models.entity.TelePayEntity;
import com.kpcnc.mydataapi.api.load.tele.models.form.TelePayForm;
import com.kpcnc.mydataapi.api.load.tele.repository.TelePayMapper;
import com.kpcnc.mydataapi.api.load.tele.service.TelePayService;
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
public class TelePayServiceImpl implements TelePayService {
    @Autowired
    TelePayMapper telePayMapper;

    @Override
    public TelePayEntity regTelePay(TelePayForm dom) {
        telePayMapper.insertTelePay(dom.getEntity());
        return telePayMapper.selectTelePay(new TelePaySearch(dom));
    }

    @Override
    public TelePayEntity modTelePay(TelePayForm dom) {
        telePayMapper.updateTelePay(dom.getEntity());
        return telePayMapper.selectTelePay(new TelePaySearch(dom));
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
