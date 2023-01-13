package com.kpcnc.mydataapi.api.base.dc.repository;

import com.kpcnc.mydataapi.api.base.dc.models.DcHistSearch;
import com.kpcnc.mydataapi.api.base.dc.models.entity.DcHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DcHistMapper{
    int insertDcHist(DcHistEntity dom);

    int updateDcHist(DcHistEntity dom);

    int deleteDcHist(DcHistEntity dom);

    DcHistEntity selectDcHist(DcHistSearch dom);

    Long selectDcHistListTotalCnt(DcHistSearch dom);

    List<DcHistEntity> selectDcHistList(DcHistSearch dom);
}
