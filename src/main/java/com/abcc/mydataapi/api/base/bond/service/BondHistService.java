package com.abcc.mydataapi.api.base.bond.service;

import com.abcc.mydataapi.api.base.bond.models.BondHistSearch;
import com.abcc.mydataapi.api.base.bond.models.entity.BondHistEntity;
import com.abcc.mydataapi.api.base.bond.models.form.BondHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface BondHistService{
    public BondHistEntity regBondHist(BondHistForm dom);

    public BondHistEntity modBondHist(BondHistForm dom);

    public void  delBondHist(BondHistForm dom);

    public BondHistEntity getBondHist(BondHistSearch dom);

    public BondHistEntity getBondHistLast(BondHistSearch dom);

    public ResultListDto<BondHistEntity> getBondHistList(BondHistSearch dom);
}
