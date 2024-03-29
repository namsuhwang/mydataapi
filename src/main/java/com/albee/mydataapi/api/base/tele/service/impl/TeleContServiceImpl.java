package com.albee.mydataapi.api.base.tele.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.tele.models.TeleContSearch;
import com.albee.mydataapi.api.base.tele.models.entity.TeleContEntity;
import com.albee.mydataapi.api.base.tele.models.form.TeleContForm;
import com.albee.mydataapi.api.base.tele.repository.TeleContMapper;
import com.albee.mydataapi.api.base.tele.service.TeleContService;
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
    public void regTeleCont(TeleContForm dom) {
        teleContMapper.insertTeleCont(dom.getEntity());
    }

    @Override
    public void updTeleCont(TeleContForm dom) {
        teleContMapper.updateTeleCont(dom.getEntity());
    }

    @Override
    public void modTeleCont(TeleContForm dom) {
        if(getTeleCont(new TeleContSearch(dom)) == null){
            regTeleCont(dom);
        }else{
            updTeleCont(dom);
        }
    }

    @Override
    public void delTeleCont(TeleContForm dom) {
        teleContMapper.deleteTeleCont(dom.getEntity());
        return;
    }

    @Override
    public void allDelTeleCont(TeleContForm dom) {
        teleContMapper.deleteAllTeleCont(dom.getEntity());
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
