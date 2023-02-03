package com.albee.mydataapi.api.base.elec.repository;

import com.albee.mydataapi.api.base.elec.models.ElecPpaySearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ElecPpayMapper{
    int insertElecPpay(ElecPpayEntity dom);

    int updateElecPpay(ElecPpayEntity dom);

    int deleteElecPpay(ElecPpayEntity dom);

    int deleteAllElecPpay(ElecPpayEntity dom);

    ElecPpayEntity selectElecPpay(ElecPpaySearch dom);

    Long selectElecPpayListTotalCnt(ElecPpaySearch dom);

    List<ElecPpayEntity> selectElecPpayList(ElecPpaySearch dom);
}
