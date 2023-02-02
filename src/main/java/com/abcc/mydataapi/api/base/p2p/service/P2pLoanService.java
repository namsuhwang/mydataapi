package com.abcc.mydataapi.api.base.p2p.service;

import com.abcc.mydataapi.api.base.p2p.models.entity.P2pLoanEntity;
import com.abcc.mydataapi.api.base.p2p.models.form.P2pLoanForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.p2p.models.P2pLoanSearch;

public interface P2pLoanService{
    public P2pLoanEntity regP2pLoan(P2pLoanForm dom);

    public P2pLoanEntity modP2pLoan(P2pLoanForm dom);

    public void  delP2pLoan(P2pLoanForm dom);

    public P2pLoanEntity getP2pLoan(P2pLoanSearch dom);

    public ResultListDto<P2pLoanEntity> getP2pLoanList(P2pLoanSearch dom);
}
