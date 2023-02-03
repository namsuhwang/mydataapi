package com.albee.mydataapi.api.base.p2p.service;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanSearch;

public interface P2pLoanService{
    public void regP2pLoan(P2pLoanForm dom);

    public void updP2pLoan(P2pLoanForm dom);

    public void modP2pLoan(P2pLoanForm dom);

    public void delP2pLoan(P2pLoanForm dom);

    public void allDelP2pLoan(P2pLoanForm dom);

    public P2pLoanEntity getP2pLoan(P2pLoanSearch dom);

    public P2pLoanEntity getP2pLoanLast(P2pLoanSearch dom);

    public ResultListDto<P2pLoanEntity> getP2pLoanList(P2pLoanSearch dom);
}
