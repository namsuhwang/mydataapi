package com.albee.mydataapi.api.base.tele.repository;

import com.albee.mydataapi.api.base.tele.models.TelePaySearch;
import com.albee.mydataapi.api.base.tele.models.entity.TelePayEntity;
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
