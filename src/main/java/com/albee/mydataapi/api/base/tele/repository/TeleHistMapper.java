package com.albee.mydataapi.api.base.tele.repository;

import com.albee.mydataapi.api.base.tele.models.TeleHistSearch;
import com.albee.mydataapi.api.base.tele.models.entity.TeleHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeleHistMapper{
    int insertTeleHist(TeleHistEntity dom);

    int updateTeleHist(TeleHistEntity dom);

    int deleteTeleHist(TeleHistEntity dom);

    TeleHistEntity selectTeleHist(TeleHistSearch dom);

    TeleHistEntity selectTeleHistLast(TeleHistSearch dom);

    Long selectTeleHistListTotalCnt(TeleHistSearch dom);

    List<TeleHistEntity> selectTeleHistList(TeleHistSearch dom);
}
