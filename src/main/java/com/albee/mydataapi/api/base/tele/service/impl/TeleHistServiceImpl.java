package com.albee.mydataapi.api.base.tele.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.tele.models.TeleHistSearch;
import com.albee.mydataapi.api.base.tele.models.entity.TeleHistEntity;
import com.albee.mydataapi.api.base.tele.models.form.TeleHistForm;
import com.albee.mydataapi.api.base.tele.repository.TeleHistMapper;
import com.albee.mydataapi.api.base.tele.service.TeleHistService;
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
public class TeleHistServiceImpl implements TeleHistService {
    @Autowired
    TeleHistMapper teleHistMapper;

    @Override
    public void regTeleHist(TeleHistForm dom) {
        teleHistMapper.insertTeleHist(dom.getEntity());
    }

    @Override
    public void updTeleHist(TeleHistForm dom) {
        teleHistMapper.updateTeleHist(dom.getEntity());
    }

    @Override
    public void modTeleHist(TeleHistForm dom) {
        if(getTeleHist(new TeleHistSearch(dom)) == null){
            regTeleHist(dom);
        }else{
            updTeleHist(dom);
        }
    }

    @Override
    public void delTeleHist(TeleHistForm dom) {
        teleHistMapper.deleteTeleHist(dom.getEntity());
        return;
    }

    @Override
    public TeleHistEntity getTeleHist(TeleHistSearch dom) {
        return teleHistMapper.selectTeleHist(dom);
    }

    @Override
    public TeleHistEntity getTeleHistLast(TeleHistSearch dom) {
        return teleHistMapper.selectTeleHistLast(dom);
    }
    @Override
    public ResultListDto<TeleHistEntity> getTeleHistList(TeleHistSearch dom) {
        ResultListDto<TeleHistEntity> result = new ResultListDto<>();
        Long totalCnt = teleHistMapper.selectTeleHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<TeleHistEntity> list = teleHistMapper.selectTeleHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
