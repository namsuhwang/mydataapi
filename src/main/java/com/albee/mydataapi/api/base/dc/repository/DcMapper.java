package com.albee.mydataapi.api.base.dc.repository;

import com.albee.mydataapi.api.base.dc.models.entity.DcEntity;
import com.albee.mydataapi.api.base.dc.models.DcSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DcMapper{
    int insertDc(DcEntity dom);

    int updateDc(DcEntity dom);

    int deleteDc(DcEntity dom);

    int deleteAllDc(DcEntity dom);

    DcEntity selectDc(DcSearch dom);

    Long selectDcListTotalCnt(DcSearch dom);

    List<DcEntity> selectDcList(DcSearch dom);
}
