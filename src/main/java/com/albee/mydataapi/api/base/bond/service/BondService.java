package com.albee.mydataapi.api.base.bond.service;

import com.albee.mydataapi.api.base.bond.models.BondSearch;
import com.albee.mydataapi.api.base.bond.models.entity.BondEntity;
import com.albee.mydataapi.api.base.bond.models.form.BondForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface BondService{
    public BondEntity regBond(BondForm dom);

    public BondEntity modBond(BondForm dom);

    public void  delBond(BondForm dom);

    public void  allDelBond(BondForm dom);

    public BondEntity getBond(BondSearch dom);

    public ResultListDto<BondEntity> getBondList(BondSearch dom);
}
