package com.abcc.mydataapi.api.base.p2p.service;

import com.abcc.mydataapi.api.base.p2p.models.entity.P2pLoanAddEntity;
import com.abcc.mydataapi.api.base.p2p.models.form.P2pLoanAddForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.p2p.models.P2pLoanAddSearch;

public interface P2pLoanAddService{
    public P2pLoanAddEntity regP2pLoanAdd(P2pLoanAddForm dom);

    public P2pLoanAddEntity modP2pLoanAdd(P2pLoanAddForm dom);

    public void  delP2pLoanAdd(P2pLoanAddForm dom);

    public P2pLoanAddEntity getP2pLoanAdd(P2pLoanAddSearch dom);

    public ResultListDto<P2pLoanAddEntity> getP2pLoanAddList(P2pLoanAddSearch dom);
}
