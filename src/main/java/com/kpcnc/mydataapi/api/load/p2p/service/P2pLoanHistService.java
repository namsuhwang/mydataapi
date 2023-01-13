package com.kpcnc.mydataapi.api.load.p2p.service;

import com.kpcnc.mydataapi.api.load.p2p.models.P2pLoanHistSearch;
import com.kpcnc.mydataapi.api.load.p2p.models.entity.P2pLoanHistEntity;
import com.kpcnc.mydataapi.api.load.p2p.models.form.P2pLoanHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface P2pLoanHistService{
    public P2pLoanHistEntity regP2pLoanHist(P2pLoanHistForm dom);

    public P2pLoanHistEntity modP2pLoanHist(P2pLoanHistForm dom);

    public void  delP2pLoanHist(P2pLoanHistForm dom);

    public P2pLoanHistEntity getP2pLoanHist(P2pLoanHistSearch dom);

    public ResultListDto<P2pLoanHistEntity> getP2pLoanHistList(P2pLoanHistSearch dom);
}
