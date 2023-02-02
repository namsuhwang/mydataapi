package com.albee.mydataapi.api.base.tele.repository;

import com.albee.mydataapi.api.base.tele.models.TeleChargeSearch;
import com.albee.mydataapi.api.base.tele.models.entity.TeleChargeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeleChargeMapper{
    int insertTeleCharge(TeleChargeEntity dom);

    int updateTeleCharge(TeleChargeEntity dom);

    int deleteTeleCharge(TeleChargeEntity dom);

    TeleChargeEntity selectTeleCharge(TeleChargeSearch dom);

    Long selectTeleChargeListTotalCnt(TeleChargeSearch dom);

    List<TeleChargeEntity> selectTeleChargeList(TeleChargeSearch dom);
}
