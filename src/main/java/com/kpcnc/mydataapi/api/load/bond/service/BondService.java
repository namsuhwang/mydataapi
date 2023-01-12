package com.kpcnc.mydataapi.api.load.bond.service;

import com.kpcnc.mydataapi.api.load.bond.models.BondSearch;
import com.kpcnc.mydataapi.api.load.bond.models.entity.BondEntity;
import com.kpcnc.mydataapi.api.load.bond.models.form.BondForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BondService{
    public BondEntity regBond(BondForm dom);

    public BondEntity modBond(BondForm dom);

    public void  delBond(BondForm dom);

    public BondEntity getBond(BondSearch dom);

    public ResultListDto<BondEntity> getBondList(BondSearch dom);
}
