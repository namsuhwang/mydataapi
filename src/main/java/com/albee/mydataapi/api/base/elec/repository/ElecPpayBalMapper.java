package com.albee.mydataapi.api.base.elec.repository;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayBalEntity;
import com.albee.mydataapi.api.base.elec.models.ElecPpayBalSearch;
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
