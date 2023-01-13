package com.kpcnc.mydataapi.api.load.tele.service.impl;

import com.kpcnc.mydataapi.api.load.tele.models.TeleContSearch;
import com.kpcnc.mydataapi.api.load.tele.models.entity.TeleContEntity;
import com.kpcnc.mydataapi.api.load.tele.models.form.TeleContForm;
import com.kpcnc.mydataapi.api.load.tele.repository.TeleContMapper;
import com.kpcnc.mydataapi.api.load.tele.service.TeleContService;
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
public class TeleContServiceImpl implements TeleContService {
    @Autowired
    TeleContMapper teleContMapper;

    @Override
    public TeleContEntity regTeleCont(TeleContForm dom) {
        teleContMapper.insertTeleCont(dom.getEntity());
        return teleContMapper.selectTeleCont(new TeleContSearch(dom));
    }

    @Override
    public TeleContEntity modTeleCont(TeleContForm dom) {
        teleContMapper.updateTeleCont(dom.getEntity());
        return teleContMapper.selectTeleCont(new TeleContSearch(dom));
    }

    @Override
    public void delTeleCont(TeleContForm dom) {
        teleContMapper.deleteTeleCont(dom.getEntity());
        return;
    }

    @Override
    public TeleContEntity getTeleCont(TeleContSearch dom) {
        return teleContMapper.selectTeleCont(dom);
    }

    @Override
    public ResultListDto<TeleContEntity> getTeleContList(TeleContSearch dom) {
        ResultListDto<TeleContEntity> result = new ResultListDto<>();
        Long totalCnt = teleContMapper.selectTeleContListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<TeleContEntity> list = teleContMapper.selectTeleContList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
