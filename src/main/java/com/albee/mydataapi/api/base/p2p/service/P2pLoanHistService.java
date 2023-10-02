package com.albee.mydataapi.api.base.p2p.service;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanHistEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanHistSearch;

public interface P2pLoanHistService{
    public void regP2pLoanHist(P2pLoanHistForm dom);

    public void updP2pLoanHist(P2pLoanHistForm dom);

    public void modP2pLoanHist(P2pLoanHistForm dom);

    public void delP2pLoanHist(P2pLoanHistForm dom);

    public P2pLoanHistEntity getP2pLoanHist(P2pLoanHistSearch dom);

    public P2pLoanHistEntity getP2pLoanHistLast(P2pLoanHistSearch dom);

    public ResultListDto<P2pLoanHistEntity> getP2pLoanHistList(P2pLoanHistSearch dom);
}
