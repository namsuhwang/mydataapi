package com.albee.mydataapi.api.base.bond.repository;

import com.albee.mydataapi.api.base.bond.models.BondSearch;
import com.albee.mydataapi.api.base.bond.models.entity.BondEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BondMapper{
    int insertBond(BondEntity dom);

    int updateBond(BondEntity dom);

    int deleteBond(BondEntity dom);

    int deleteAllBond(BondEntity dom);

    BondEntity selectBond(BondSearch dom);

    Long selectBondListTotalCnt(BondSearch dom);

    List<BondEntity> selectBondList(BondSearch dom);
}
