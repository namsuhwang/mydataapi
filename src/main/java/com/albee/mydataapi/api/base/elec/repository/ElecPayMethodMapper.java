package com.albee.mydataapi.api.base.elec.repository;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPayMethodEntity;
import com.albee.mydataapi.api.base.elec.models.ElecPayMethodSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ElecPayMethodMapper{
    int insertElecPayMethod(ElecPayMethodEntity dom);

    int updateElecPayMethod(ElecPayMethodEntity dom);

    int deleteElecPayMethod(ElecPayMethodEntity dom);

    int deleteAllElecPayMethod(ElecPayMethodEntity dom);

    ElecPayMethodEntity selectElecPayMethod(ElecPayMethodSearch dom);

    ElecPayMethodEntity selectElecPayMethodLast(ElecPayMethodSearch dom);

    Long selectElecPayMethodListTotalCnt(ElecPayMethodSearch dom);

    List<ElecPayMethodEntity> selectElecPayMethodList(ElecPayMethodSearch dom);
}