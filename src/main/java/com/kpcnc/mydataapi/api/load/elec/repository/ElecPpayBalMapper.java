package com.kpcnc.mydataapi.api.load.elec.repository;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPpayBalSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayBalEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ElecPpayBalMapper{
    int insertElecPpayBal(ElecPpayBalEntity dom);

    int updateElecPpayBal(ElecPpayBalEntity dom);

    int deleteElecPpayBal(ElecPpayBalEntity dom);

    ElecPpayBalEntity selectElecPpayBal(ElecPpayBalSearch dom);

    Long selectElecPpayBalListTotalCnt(ElecPpayBalSearch dom);

    List<ElecPpayBalEntity> selectElecPpayBalList(ElecPpayBalSearch dom);
}
