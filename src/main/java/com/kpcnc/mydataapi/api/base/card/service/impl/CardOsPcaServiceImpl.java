package com.kpcnc.mydataapi.api.base.card.service.impl;

import com.kpcnc.mydataapi.api.base.card.models.CardOsPcaSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardOsPcaEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardOsPcaForm;
import com.kpcnc.mydataapi.api.base.card.repository.CardOsPcaMapper;
import com.kpcnc.mydataapi.api.base.card.service.CardOsPcaService;
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
public class CardOsPcaServiceImpl implements CardOsPcaService {
    @Autowired
    CardOsPcaMapper cardOsPcaMapper;

    @Override
    public void regCardOsPca(CardOsPcaForm dom) {
        cardOsPcaMapper.insertCardOsPca(dom.getEntity());
        return;
    }

    @Override
    public void updCardOsPca(CardOsPcaForm dom) {
        cardOsPcaMapper.updateCardOsPca(dom.getEntity());
        return;
    }

    @Override
    public void modCardOsPca(CardOsPcaForm dom) {
        if(getCardOsPca(new CardOsPcaSearch(dom)) == null){
            regCardOsPca(dom);
        }else{
            updCardOsPca(dom);
        }
        return;
    }

    @Override
    public void delCardOsPca(CardOsPcaForm dom) {
        cardOsPcaMapper.deleteCardOsPca(dom.getEntity());
        return;
    }

    @Override
    public CardOsPcaEntity getCardOsPca(CardOsPcaSearch dom) {
        return cardOsPcaMapper.selectCardOsPca(dom);
    }

    @Override
    public CardOsPcaEntity getCardOsPcaLast(CardOsPcaSearch dom) {
        return cardOsPcaMapper.selectCardOsPcaLast(dom);
    }

    @Override
    public ResultListDto<CardOsPcaEntity> getCardOsPcaList(CardOsPcaSearch dom) {
        ResultListDto<CardOsPcaEntity> result = new ResultListDto<>();
        Long totalCnt = cardOsPcaMapper.selectCardOsPcaListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardOsPcaEntity> list = cardOsPcaMapper.selectCardOsPcaList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
