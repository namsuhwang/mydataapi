package com.albee.mydataapi.api.base.p2p.service;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanHistEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanHistSearch;

public interface P2pLoanHistService{
    public P2pLoanHistEntity regP2pLoanHist(P2pLoanHistForm dom);

    public P2pLoanHistEntity modP2pLoanHist(P2pLoanHistForm dom);

    public void  delP2pLoanHist(P2pLoanHistForm dom);

    public P2pLoanHistEntity getP2pLoanHist(P2pLoanHistSearch dom);

    public ResultListDto<P2pLoanHistEntity> getP2pLoanHistList(P2pLoanHistSearch dom);
}
