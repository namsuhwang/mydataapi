package com.kpcnc.mydataapi.api.load.tele.repository;

import com.kpcnc.mydataapi.api.load.tele.models.TelePaySearch;
import com.kpcnc.mydataapi.api.load.tele.models.entity.TelePayEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TelePayMapper{
    int insertTelePay(TelePayEntity dom);

    int updateTelePay(TelePayEntity dom);

    int deleteTelePay(TelePayEntity dom);

    TelePayEntity selectTelePay(TelePaySearch dom);

    Long selectTelePayListTotalCnt(TelePaySearch dom);

    List<TelePayEntity> selectTelePayList(TelePaySearch dom);
}
