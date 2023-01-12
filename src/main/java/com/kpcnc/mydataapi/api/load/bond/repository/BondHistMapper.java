package com.kpcnc.mydataapi.api.load.bond.repository;

import com.kpcnc.mydataapi.api.load.bond.models.BondHistSearch;
import com.kpcnc.mydataapi.api.load.bond.models.entity.BondHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BondHistMapper{
    int insertBondHist(BondHistEntity dom);

    int updateBondHist(BondHistEntity dom);

    int deleteBondHist(BondHistEntity dom);

    BondHistEntity selectBondHist(BondHistSearch dom);

    Long selectBondHistListTotalCnt(BondHistSearch dom);

    List<BondHistEntity> selectBondHistList(BondHistSearch dom);
}
