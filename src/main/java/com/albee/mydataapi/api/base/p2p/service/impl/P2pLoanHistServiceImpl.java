package com.albee.mydataapi.api.base.p2p.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanHistSearch;
import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanHistEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanHistForm;
import com.albee.mydataapi.api.base.p2p.repository.P2pLoanHistMapper;
import com.albee.mydataapi.api.base.p2p.service.P2pLoanHistService;
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
public class P2pLoanHistServiceImpl implements P2pLoanHistService {
    @Autowired
    P2pLoanHistMapper p2pLoanHistMapper;

    @Override
    public P2pLoanHistEntity regP2pLoanHist(P2pLoanHistForm dom) {
        p2pLoanHistMapper.insertP2pLoanHist(dom.getEntity());
        return p2pLoanHistMapper.selectP2pLoanHist(new P2pLoanHistSearch(dom));
    }

    @Override
    public P2pLoanHistEntity modP2pLoanHist(P2pLoanHistForm dom) {
        p2pLoanHistMapper.updateP2pLoanHist(dom.getEntity());
        return p2pLoanHistMapper.selectP2pLoanHist(new P2pLoanHistSearch(dom));
    }

    @Override
    public void delP2pLoanHist(P2pLoanHistForm dom) {
        p2pLoanHistMapper.deleteP2pLoanHist(dom.getEntity());
        return;
    }

    @Override
    public P2pLoanHistEntity getP2pLoanHist(P2pLoanHistSearch dom) {
        return p2pLoanHistMapper.selectP2pLoanHist(dom);
    }

    @Override
    public ResultListDto<P2pLoanHistEntity> getP2pLoanHistList(P2pLoanHistSearch dom) {
        ResultListDto<P2pLoanHistEntity> result = new ResultListDto<>();
        Long totalCnt = p2pLoanHistMapper.selectP2pLoanHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<P2pLoanHistEntity> list = p2pLoanHistMapper.selectP2pLoanHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
