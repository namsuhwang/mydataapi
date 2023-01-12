package com.kpcnc.mydataapi.api.load.dc.repository;

import com.kpcnc.mydataapi.api.load.dc.models.DcSearch;
import com.kpcnc.mydataapi.api.load.dc.models.entity.DcEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DcMapper{
    int insertDc(DcEntity dom);

    int updateDc(DcEntity dom);

    int deleteDc(DcEntity dom);

    DcEntity selectDc(DcSearch dom);

    Long selectDcListTotalCnt(DcSearch dom);

    List<DcEntity> selectDcList(DcSearch dom);
}
