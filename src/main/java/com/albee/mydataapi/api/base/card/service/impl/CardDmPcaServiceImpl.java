package com.albee.mydataapi.api.base.card.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.card.models.CardDmPcaSearch;
import com.albee.mydataapi.api.base.card.models.entity.CardDmPcaEntity;
import com.albee.mydataapi.api.base.card.models.form.CardDmPcaForm;
import com.albee.mydataapi.api.base.card.repository.CardDmPcaMapper;
import com.albee.mydataapi.api.base.card.service.CardDmPcaService;
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
    public void regCardDmPca(CardDmPcaForm dom) {
        cardDmPcaMapper.insertCardDmPca(dom.getEntity());
        return;
    }

    @Override
    public void updCardDmPca(CardDmPcaForm dom) {
        cardDmPcaMapper.updateCardDmPca(dom.getEntity());
        return;
    }


    @Override
    public void modCardDmPca(CardDmPcaForm dom) {
        if(getCardDmPca(new CardDmPcaSearch(dom)) == null){
            regCardDmPca(dom);
        }else{
            updCardDmPca(dom);
        }
        return;
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
    public CardDmPcaEntity getCardDmPcaLast(CardDmPcaSearch dom) {
        return cardDmPcaMapper.selectCardDmPcaLast(dom);
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
