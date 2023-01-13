package com.kpcnc.mydataapi.api.base.bond.service;

import com.kpcnc.mydataapi.api.base.bond.models.BondBalSearch;
import com.kpcnc.mydataapi.api.base.bond.models.entity.BondBalEntity;
import com.kpcnc.mydataapi.api.base.bond.models.form.BondBalForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface BondBalService{
    public BondBalEntity regBondBal(BondBalForm dom);

    public BondBalEntity modBondBal(BondBalForm dom);

    public void  delBondBal(BondBalForm dom);

    public BondBalEntity getBondBal(BondBalSearch dom);

    public ResultListDto<BondBalEntity> getBondBalList(BondBalSearch dom);
}