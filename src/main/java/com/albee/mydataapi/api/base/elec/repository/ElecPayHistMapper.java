package com.albee.mydataapi.api.base.elec.repository;

import com.albee.mydataapi.api.base.elec.models.ElecPayHistSearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPayHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ElecPayHistMapper{
    int insertElecPayHist(ElecPayHistEntity dom);

    int updateElecPayHist(ElecPayHistEntity dom);

    int deleteElecPayHist(ElecPayHistEntity dom);

    ElecPayHistEntity selectElecPayHist(ElecPayHistSearch dom);

    ElecPayHistEntity selectElecPayHistLast(ElecPayHistSearch dom);

    Long selectElecPayHistListTotalCnt(ElecPayHistSearch dom);

    List<ElecPayHistEntity> selectElecPayHistList(ElecPayHistSearch dom);
}
