package com.albee.mydataapi.api.base.p2p.service;

import com.albee.mydataapi.api.base.p2p.models.entity.P2pLoanAddEntity;
import com.albee.mydataapi.api.base.p2p.models.form.P2pLoanAddForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.p2p.models.P2pLoanAddSearch;

public interface P2pLoanAddService{
    public void regP2pLoanAdd(P2pLoanAddForm dom);

    public void updP2pLoanAdd(P2pLoanAddForm dom);

    public void modP2pLoanAdd(P2pLoanAddForm dom);

    public void delP2pLoanAdd(P2pLoanAddForm dom);

    public P2pLoanAddEntity getP2pLoanAdd(P2pLoanAddSearch dom);

    public ResultListDto<P2pLoanAddEntity> getP2pLoanAddList(P2pLoanAddSearch dom);
}
