package com.albee.mydataapi.api.base.elec.repository;

import com.albee.mydataapi.api.base.elec.models.entity.ElecAccEntity;
import com.albee.mydataapi.api.base.elec.models.ElecAccSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ElecAccMapper{
    int insertElecAcc(ElecAccEntity dom);

    int updateElecAcc(ElecAccEntity dom);

    int deleteElecAcc(ElecAccEntity dom);

    ElecAccEntity selectElecAcc(ElecAccSearch dom);

    Long selectElecAccListTotalCnt(ElecAccSearch dom);

    List<ElecAccEntity> selectElecAccList(ElecAccSearch dom);
}
