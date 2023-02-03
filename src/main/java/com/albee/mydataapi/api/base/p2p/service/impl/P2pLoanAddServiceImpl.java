package com.albee.mydataapi.api.base.p2p.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanAddSearch;
import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanAddEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanAddForm;
import com.albee.mydataapi.api.base.p2p.repository.P2pLoanAddMapper;
import com.albee.mydataapi.api.base.p2p.service.P2pLoanAddService;
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
public class P2pLoanAddServiceImpl implements P2pLoanAddService {
    @Autowired
    P2pLoanAddMapper p2pLoanAddMapper;

    @Override
    public void regP2pLoanAdd(P2pLoanAddForm dom) {
        p2pLoanAddMapper.insertP2pLoanAdd(dom.getEntity());
    }

    @Override
    public void updP2pLoanAdd(P2pLoanAddForm dom) {
        p2pLoanAddMapper.updateP2pLoanAdd(dom.getEntity());
    }

    @Override
    public void modP2pLoanAdd(P2pLoanAddForm dom) {
        if(getP2pLoanAdd(new P2pLoanAddSearch(dom)) == null){
            regP2pLoanAdd(dom);
        }else{
            updP2pLoanAdd(dom);
        }
    }

    @Override
    public void delP2pLoanAdd(P2pLoanAddForm dom) {
        p2pLoanAddMapper.deleteP2pLoanAdd(dom.getEntity());
        return;
    }

    @Override
    public P2pLoanAddEntity getP2pLoanAdd(P2pLoanAddSearch dom) {
        return p2pLoanAddMapper.selectP2pLoanAdd(dom);
    }

    @Override
    public ResultListDto<P2pLoanAddEntity> getP2pLoanAddList(P2pLoanAddSearch dom) {
        ResultListDto<P2pLoanAddEntity> result = new ResultListDto<>();
        Long totalCnt = p2pLoanAddMapper.selectP2pLoanAddListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<P2pLoanAddEntity> list = p2pLoanAddMapper.selectP2pLoanAddList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
