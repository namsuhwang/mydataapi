package com.kpcnc.mydataapi.api.load.bond.service;

import com.kpcnc.mydataapi.api.load.bond.models.BondHistSearch;
import com.kpcnc.mydataapi.api.load.bond.models.entity.BondHistEntity;
import com.kpcnc.mydataapi.api.load.bond.models.form.BondHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BondHistService{
    public BondHistEntity regBondHist(BondHistForm dom);

    public BondHistEntity modBondHist(BondHistForm dom);

    public void  delBondHist(BondHistForm dom);

    public BondHistEntity getBondHist(BondHistSearch dom);

    public ResultListDto<BondHistEntity> getBondHistList(BondHistSearch dom);
}
