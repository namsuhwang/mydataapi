package com.kpcnc.mydataapi.api.load.bond.repository;

import com.kpcnc.mydataapi.api.load.bond.models.BondBalSearch;
import com.kpcnc.mydataapi.api.load.bond.models.entity.BondBalEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BondBalMapper{
    int insertBondBal(BondBalEntity dom);

    int updateBondBal(BondBalEntity dom);

    int deleteBondBal(BondBalEntity dom);

    BondBalEntity selectBondBal(BondBalSearch dom);

    Long selectBondBalListTotalCnt(BondBalSearch dom);

    List<BondBalEntity> selectBondBalList(BondBalSearch dom);
}
