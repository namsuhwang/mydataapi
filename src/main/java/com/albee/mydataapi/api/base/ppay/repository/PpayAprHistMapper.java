package com.albee.mydataapi.api.base.ppay.repository;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayAprHistEntity;
import com.albee.mydataapi.api.base.ppay.models.PpayAprHistSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PpayAprHistMapper{
    int insertPpayAprHist(PpayAprHistEntity dom);

    int updatePpayAprHist(PpayAprHistEntity dom);

    int deletePpayAprHist(PpayAprHistEntity dom);

    PpayAprHistEntity selectPpayAprHist(PpayAprHistSearch dom);

    PpayAprHistEntity selectPpayAprHistLast(PpayAprHistSearch dom);

    Long selectPpayAprHistListTotalCnt(PpayAprHistSearch dom);

    List<PpayAprHistEntity> selectPpayAprHistList(PpayAprHistSearch dom);
}
