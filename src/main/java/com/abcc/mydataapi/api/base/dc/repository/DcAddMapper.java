package com.abcc.mydataapi.api.base.dc.repository;

import com.abcc.mydataapi.api.base.dc.models.entity.DcAddEntity;
import com.abcc.mydataapi.api.base.dc.models.DcAddSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DcAddMapper{
    int insertDcAdd(DcAddEntity dom);

    int updateDcAdd(DcAddEntity dom);

    int deleteDcAdd(DcAddEntity dom);

    DcAddEntity selectDcAdd(DcAddSearch dom);

    DcAddEntity selectDcAddLast(DcAddSearch dom);

    Long selectDcAddListTotalCnt(DcAddSearch dom);

    List<DcAddEntity> selectDcAddList(DcAddSearch dom);
}
