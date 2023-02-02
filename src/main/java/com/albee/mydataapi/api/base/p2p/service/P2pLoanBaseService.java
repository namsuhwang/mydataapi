package com.albee.mydataapi.api.base.p2p.service;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanBaseEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanBaseSearch;

public interface P2pLoanBaseService{
    public P2pLoanBaseEntity regP2pLoanBase(P2pLoanBaseForm dom);

    public P2pLoanBaseEntity modP2pLoanBase(P2pLoanBaseForm dom);

    public void  delP2pLoanBase(P2pLoanBaseForm dom);

    public P2pLoanBaseEntity getP2pLoanBase(P2pLoanBaseSearch dom);

    public ResultListDto<P2pLoanBaseEntity> getP2pLoanBaseList(P2pLoanBaseSearch dom);
}
