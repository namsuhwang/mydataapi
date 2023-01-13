package com.kpcnc.mydataapi.api.load.p2p.service.impl;

import com.kpcnc.mydataapi.api.load.p2p.models.P2pLoanSearch;
import com.kpcnc.mydataapi.api.load.p2p.models.entity.P2pLoanEntity;
import com.kpcnc.mydataapi.api.load.p2p.models.form.P2pLoanForm;
import com.kpcnc.mydataapi.api.load.p2p.repository.P2pLoanMapper;
import com.kpcnc.mydataapi.api.load.p2p.service.P2pLoanService;
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
public class P2pLoanServiceImpl implements P2pLoanService {
    @Autowired
    P2pLoanMapper p2pLoanMapper;

    @Override
    public P2pLoanEntity regP2pLoan(P2pLoanForm dom) {
        p2pLoanMapper.insertP2pLoan(dom.getEntity());
        return p2pLoanMapper.selectP2pLoan(new P2pLoanSearch(dom));
    }

    @Override
    public P2pLoanEntity modP2pLoan(P2pLoanForm dom) {
        p2pLoanMapper.updateP2pLoan(dom.getEntity());
        return p2pLoanMapper.selectP2pLoan(new P2pLoanSearch(dom));
    }

    @Override
    public void delP2pLoan(P2pLoanForm dom) {
        p2pLoanMapper.deleteP2pLoan(dom.getEntity());
        return;
    }

    @Override
    public P2pLoanEntity getP2pLoan(P2pLoanSearch dom) {
        return p2pLoanMapper.selectP2pLoan(dom);
    }

    @Override
    public ResultListDto<P2pLoanEntity> getP2pLoanList(P2pLoanSearch dom) {
        ResultListDto<P2pLoanEntity> result = new ResultListDto<>();
        Long totalCnt = p2pLoanMapper.selectP2pLoanListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<P2pLoanEntity> list = p2pLoanMapper.selectP2pLoanList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
