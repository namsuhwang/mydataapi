package com.kpcnc.mydataapi.api.base.elec.repository;

import com.kpcnc.mydataapi.api.ElecPpayAutoChargeSearch;
import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPpayAutoChargeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ElecPpayAutoChargeMapper{
    int insertElecPpayAutoCharge(ElecPpayAutoChargeEntity dom);

    int updateElecPpayAutoCharge(ElecPpayAutoChargeEntity dom);

    int deleteElecPpayAutoCharge(ElecPpayAutoChargeEntity dom);

    ElecPpayAutoChargeEntity selectElecPpayAutoCharge(ElecPpayAutoChargeSearch dom);

    Long selectElecPpayAutoChargeListTotalCnt(ElecPpayAutoChargeSearch dom);

    List<ElecPpayAutoChargeEntity> selectElecPpayAutoChargeList(ElecPpayAutoChargeSearch dom);
}
