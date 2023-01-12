package com.kpcnc.mydataapi.api.load.dc.repository;

import com.kpcnc.mydataapi.api.load.dc.models.DcAddSearch;
import com.kpcnc.mydataapi.api.load.dc.models.entity.DcAddEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DcAddMapper{
    int insertDcAdd(DcAddEntity dom);

    int updateDcAdd(DcAddEntity dom);

    int deleteDcAdd(DcAddEntity dom);

    DcAddEntity selectDcAdd(DcAddSearch dom);

    Long selectDcAddListTotalCnt(DcAddSearch dom);

    List<DcAddEntity> selectDcAddList(DcAddSearch dom);
}
