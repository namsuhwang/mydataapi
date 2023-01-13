package com.kpcnc.mydataapi.api.base.elec.repository;

import com.kpcnc.mydataapi.api.base.elec.models.ElecAccSearch;
import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecAccEntity;
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
