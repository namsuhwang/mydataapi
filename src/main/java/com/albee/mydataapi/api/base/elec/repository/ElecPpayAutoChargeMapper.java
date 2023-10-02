package com.albee.mydataapi.api.base.elec.repository;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayAutoChargeEntity;
import com.albee.mydataapi.api.base.elec.models.ElecPpayAutoChargeSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ElecPpayAutoChargeMapper{
    int insertElecPpayAutoCharge(ElecPpayAutoChargeEntity dom);

    int updateElecPpayAutoCharge(ElecPpayAutoChargeEntity dom);

    int deleteElecPpayAutoCharge(ElecPpayAutoChargeEntity dom);

    int deleteAllElecPpayAutoCharge(ElecPpayAutoChargeEntity dom);

    ElecPpayAutoChargeEntity selectElecPpayAutoCharge(ElecPpayAutoChargeSearch dom);

    ElecPpayAutoChargeEntity selectElecPpayAutoChargeLast(ElecPpayAutoChargeSearch dom);

    Long selectElecPpayAutoChargeListTotalCnt(ElecPpayAutoChargeSearch dom);

    List<ElecPpayAutoChargeEntity> selectElecPpayAutoChargeList(ElecPpayAutoChargeSearch dom);
}
