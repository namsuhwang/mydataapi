package com.kpcnc.mydataapi.api.base.ppay.repository;

import com.kpcnc.mydataapi.api.base.ppay.models.PpayHistSearch;
import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PpayHistMapper{
    int insertPpayHist(PpayHistEntity dom);

    int updatePpayHist(PpayHistEntity dom);

    int deletePpayHist(PpayHistEntity dom);

    PpayHistEntity selectPpayHist(PpayHistSearch dom);

    PpayHistEntity selectPpayHistLast(PpayHistSearch dom);

    Long selectPpayHistListTotalCnt(PpayHistSearch dom);

    List<PpayHistEntity> selectPpayHistList(PpayHistSearch dom);
}
