package com.kpcnc.mydataapi.api.load.bond.service;

import com.kpcnc.mydataapi.api.load.bond.models.BondBalSearch;
import com.kpcnc.mydataapi.api.load.bond.models.entity.BondBalEntity;
import com.kpcnc.mydataapi.api.load.bond.models.form.BondBalForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface BondBalService{
    public BondBalEntity regBondBal(BondBalForm dom);

    public BondBalEntity modBondBal(BondBalForm dom);

    public void  delBondBal(BondBalForm dom);

    public BondBalEntity getBondBal(BondBalSearch dom);

    public ResultListDto<BondBalEntity> getBondBalList(BondBalSearch dom);
}
