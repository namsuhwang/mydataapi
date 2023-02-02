package com.abcc.mydataapi.api.base.bond.service;

import com.abcc.mydataapi.api.base.bond.models.BondSearch;
import com.abcc.mydataapi.api.base.bond.models.entity.BondEntity;
import com.abcc.mydataapi.api.base.bond.models.form.BondForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface BondService{
    public BondEntity regBond(BondForm dom);

    public BondEntity modBond(BondForm dom);

    public void  delBond(BondForm dom);

    public void  allDelBond(BondForm dom);

    public BondEntity getBond(BondSearch dom);

    public ResultListDto<BondEntity> getBondList(BondSearch dom);
}
