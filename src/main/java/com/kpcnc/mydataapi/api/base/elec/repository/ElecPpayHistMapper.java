package com.kpcnc.mydataapi.api.base.elec.repository;

import com.kpcnc.mydataapi.api.base.elec.models.ElecPpayHistSearch;
import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPpayHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ElecPpayHistMapper{
    int insertElecPpayHist(ElecPpayHistEntity dom);

    int updateElecPpayHist(ElecPpayHistEntity dom);

    int deleteElecPpayHist(ElecPpayHistEntity dom);

    ElecPpayHistEntity selectElecPpayHist(ElecPpayHistSearch dom);

    Long selectElecPpayHistListTotalCnt(ElecPpayHistSearch dom);

    List<ElecPpayHistEntity> selectElecPpayHistList(ElecPpayHistSearch dom);
}
