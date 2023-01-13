package com.kpcnc.mydataapi.api.base.card.service.impl;

import com.kpcnc.mydataapi.api.base.card.models.CardDmPcaSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardDmPcaEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardDmPcaForm;
import com.kpcnc.mydataapi.api.base.card.repository.CardDmPcaMapper;
import com.kpcnc.mydataapi.api.base.card.service.CardDmPcaService;
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
public class CardDmPcaServiceImpl implements CardDmPcaService {
    @Autowired
    CardDmPcaMapper cardDmPcaMapper;

    @Override
    public CardDmPcaEntity regCardDmPca(CardDmPcaForm dom) {
        cardDmPcaMapper.insertCardDmPca(dom.getEntity());
        return cardDmPcaMapper.selectCardDmPca(new CardDmPcaSearch(dom));
    }

    @Override
    public CardDmPcaEntity modCardDmPca(CardDmPcaForm dom) {
        cardDmPcaMapper.updateCardDmPca(dom.getEntity());
        return cardDmPcaMapper.selectCardDmPca(new CardDmPcaSearch(dom));
    }

    @Override
    public void delCardDmPca(CardDmPcaForm dom) {
        cardDmPcaMapper.deleteCardDmPca(dom.getEntity());
        return;
    }

    @Override
    public CardDmPcaEntity getCardDmPca(CardDmPcaSearch dom) {
        return cardDmPcaMapper.selectCardDmPca(dom);
    }

    @Override
    public ResultListDto<CardDmPcaEntity> getCardDmPcaList(CardDmPcaSearch dom) {
        ResultListDto<CardDmPcaEntity> result = new ResultListDto<>();
        Long totalCnt = cardDmPcaMapper.selectCardDmPcaListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardDmPcaEntity> list = cardDmPcaMapper.selectCardDmPcaList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
