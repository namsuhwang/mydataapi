package com.albee.mydataapi.api.base.bond.repository;

import com.albee.mydataapi.api.base.bond.models.BondHistSearch;
import com.albee.mydataapi.api.base.bond.models.entity.BondHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BondHistMapper{
    int insertBondHist(BondHistEntity dom);

    int updateBondHist(BondHistEntity dom);

    int deleteBondHist(BondHistEntity dom);

    BondHistEntity selectBondHist(BondHistSearch dom);

    BondHistEntity selectBondHistLast(BondHistSearch dom);

    Long selectBondHistListTotalCnt(BondHistSearch dom);

    List<BondHistEntity> selectBondHistList(BondHistSearch dom);
}
