package com.kpcnc.mydataapi.api.load.tele.service.impl;

import com.kpcnc.mydataapi.api.load.tele.models.TeleHistSearch;
import com.kpcnc.mydataapi.api.load.tele.models.entity.TeleHistEntity;
import com.kpcnc.mydataapi.api.load.tele.models.form.TeleHistForm;
import com.kpcnc.mydataapi.api.load.tele.repository.TeleHistMapper;
import com.kpcnc.mydataapi.api.load.tele.service.TeleHistService;
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
public class TeleHistServiceImpl implements TeleHistService {
    @Autowired
    TeleHistMapper teleHistMapper;

    @Override
    public TeleHistEntity regTeleHist(TeleHistForm dom) {
        teleHistMapper.insertTeleHist(dom.getEntity());
        return teleHistMapper.selectTeleHist(new TeleHistSearch(dom));
    }

    @Override
    public TeleHistEntity modTeleHist(TeleHistForm dom) {
        teleHistMapper.updateTeleHist(dom.getEntity());
        return teleHistMapper.selectTeleHist(new TeleHistSearch(dom));
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
