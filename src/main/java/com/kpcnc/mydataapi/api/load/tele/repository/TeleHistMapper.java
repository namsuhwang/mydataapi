package com.kpcnc.mydataapi.api.load.tele.repository;

import com.kpcnc.mydataapi.api.load.tele.models.TeleHistSearch;
import com.kpcnc.mydataapi.api.load.tele.models.entity.TeleHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeleHistMapper{
    int insertTeleHist(TeleHistEntity dom);

    int updateTeleHist(TeleHistEntity dom);

    int deleteTeleHist(TeleHistEntity dom);

    TeleHistEntity selectTeleHist(TeleHistSearch dom);

    Long selectTeleHistListTotalCnt(TeleHistSearch dom);

    List<TeleHistEntity> selectTeleHistList(TeleHistSearch dom);
}
