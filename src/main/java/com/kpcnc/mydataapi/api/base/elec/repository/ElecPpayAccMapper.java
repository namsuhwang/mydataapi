package com.kpcnc.mydataapi.api.base.elec.repository;

import com.kpcnc.mydataapi.api.base.elec.models.ElecPpayAccSearch;
import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPpayAccEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ElecPpayAccMapper{
    int insertElecPpayAcc(ElecPpayAccEntity dom);

    int updateElecPpayAcc(ElecPpayAccEntity dom);

    int deleteElecPpayAcc(ElecPpayAccEntity dom);

    ElecPpayAccEntity selectElecPpayAcc(ElecPpayAccSearch dom);

    Long selectElecPpayAccListTotalCnt(ElecPpayAccSearch dom);

    List<ElecPpayAccEntity> selectElecPpayAccList(ElecPpayAccSearch dom);
}
