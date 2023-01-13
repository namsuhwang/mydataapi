package com.kpcnc.mydataapi.api.base.dc.repository;

import com.kpcnc.mydataapi.api.base.dc.models.DcBaseSearch;
import com.kpcnc.mydataapi.api.base.dc.models.entity.DcBaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DcBaseMapper{
    int insertDcBase(DcBaseEntity dom);

    int updateDcBase(DcBaseEntity dom);

    int deleteDcBase(DcBaseEntity dom);

    DcBaseEntity selectDcBase(DcBaseSearch dom);

    Long selectDcBaseListTotalCnt(DcBaseSearch dom);

    List<DcBaseEntity> selectDcBaseList(DcBaseSearch dom);
}
