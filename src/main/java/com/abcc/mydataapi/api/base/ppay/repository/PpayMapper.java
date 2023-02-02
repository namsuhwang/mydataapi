package com.abcc.mydataapi.api.base.ppay.repository;

import com.abcc.mydataapi.api.base.ppay.models.entity.PpayEntity;
import com.abcc.mydataapi.api.base.ppay.models.PpaySearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PpayMapper{
    int insertPpay(PpayEntity dom);

    int updatePpay(PpayEntity dom);

    int deletePpay(PpayEntity dom);

    int deleteAllPpay(PpayEntity dom);

    PpayEntity selectPpay(PpaySearch dom);

    Long selectPpayListTotalCnt(PpaySearch dom);

    List<PpayEntity> selectPpayList(PpaySearch dom);
}
