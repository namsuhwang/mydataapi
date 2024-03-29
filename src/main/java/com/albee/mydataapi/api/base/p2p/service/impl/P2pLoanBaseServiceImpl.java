package com.albee.mydataapi.api.base.p2p.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanBaseSearch;
import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanBaseEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanBaseForm;
import com.albee.mydataapi.api.base.p2p.repository.P2pLoanBaseMapper;
import com.albee.mydataapi.api.base.p2p.service.P2pLoanBaseService;
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
public class P2pLoanBaseServiceImpl implements P2pLoanBaseService {
    @Autowired
    P2pLoanBaseMapper p2pLoanBaseMapper;

    @Override
    public void regP2pLoanBase(P2pLoanBaseForm dom) {
        p2pLoanBaseMapper.insertP2pLoanBase(dom.getEntity());
    }

    @Override
    public void updP2pLoanBase(P2pLoanBaseForm dom) {
        p2pLoanBaseMapper.updateP2pLoanBase(dom.getEntity());
    }

    @Override
    public void modP2pLoanBase(P2pLoanBaseForm dom) {
        if(getP2pLoanBase(new P2pLoanBaseSearch(dom)) == null){
            regP2pLoanBase(dom);
        }else{
            updP2pLoanBase(dom);
        }
    }

    @Override
    public void delP2pLoanBase(P2pLoanBaseForm dom) {
        p2pLoanBaseMapper.deleteP2pLoanBase(dom.getEntity());
        return;
    }

    @Override
    public P2pLoanBaseEntity getP2pLoanBase(P2pLoanBaseSearch dom) {
        return p2pLoanBaseMapper.selectP2pLoanBase(dom);
    }

    @Override
    public ResultListDto<P2pLoanBaseEntity> getP2pLoanBaseList(P2pLoanBaseSearch dom) {
        ResultListDto<P2pLoanBaseEntity> result = new ResultListDto<>();
        Long totalCnt = p2pLoanBaseMapper.selectP2pLoanBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<P2pLoanBaseEntity> list = p2pLoanBaseMapper.selectP2pLoanBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
