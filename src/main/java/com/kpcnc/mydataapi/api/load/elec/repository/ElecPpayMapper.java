package com.kpcnc.mydataapi.api.load.elec.repository;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPpaySearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ElecPpayMapper{
    int insertElecPpay(ElecPpayEntity dom);

    int updateElecPpay(ElecPpayEntity dom);

    int deleteElecPpay(ElecPpayEntity dom);

    ElecPpayEntity selectElecPpay(ElecPpaySearch dom);

    Long selectElecPpayListTotalCnt(ElecPpaySearch dom);

    List<ElecPpayEntity> selectElecPpayList(ElecPpaySearch dom);
}
