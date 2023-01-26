package com.kpcnc.mydataapi.api.base.ppay.repository;

import com.kpcnc.mydataapi.api.base.ppay.models.PpayBalSearch;
import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PpayBalMapper{
    int insertPpayBal(PpayBalEntity dom);

    int updatePpayBal(PpayBalEntity dom);

    int deletePpayBal(PpayBalEntity dom);

    PpayBalEntity selectPpayBal(PpayBalSearch dom);

    Long selectPpayBalListTotalCnt(PpayBalSearch dom);

    List<PpayBalEntity> selectPpayBalList(PpayBalSearch dom);
}
