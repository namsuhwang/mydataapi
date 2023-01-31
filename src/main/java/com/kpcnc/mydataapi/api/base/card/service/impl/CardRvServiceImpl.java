package com.kpcnc.mydataapi.api.base.card.service.impl;

import com.kpcnc.mydataapi.api.base.card.models.CardRvSearch;
import com.kpcnc.mydataapi.api.base.card.models.entity.CardRvEntity;
import com.kpcnc.mydataapi.api.base.card.models.form.CardRvForm;
import com.kpcnc.mydataapi.api.base.card.repository.CardRvMapper;
import com.kpcnc.mydataapi.api.base.card.service.CardRvService;
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
public class CardRvServiceImpl implements CardRvService {
    @Autowired
    CardRvMapper cardRvMapper;

    @Override
    public void regCardRv(CardRvForm dom) {
        cardRvMapper.insertCardRv(dom.getEntity());
        return;
    }

    @Override
    public void updCardRv(CardRvForm dom) {
        cardRvMapper.updateCardRv(dom.getEntity());
        return;
    }

    @Override
    public void modCardRv(CardRvForm dom) {
        if(getCardRv(new CardRvSearch(dom))== null){
            regCardRv(dom);
        }else{
            updCardRv(dom);
        }
        return;
    }

    @Override
    public void delCardRv(CardRvForm dom) {
        cardRvMapper.deleteCardRv(dom.getEntity());
        return;
    }

    @Override
    public void allDelCardRv(CardRvForm dom) {
        cardRvMapper.deleteAllCardRv(dom.getEntity());
        return;
    }

    @Override
    public CardRvEntity getCardRv(CardRvSearch dom) {
        return cardRvMapper.selectCardRv(dom);
    }

    @Override
    public ResultListDto<CardRvEntity> getCardRvList(CardRvSearch dom) {
        ResultListDto<CardRvEntity> result = new ResultListDto<>();
        Long totalCnt = cardRvMapper.selectCardRvListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<CardRvEntity> list = cardRvMapper.selectCardRvList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
