package com.albee.mydataapi.api.base.tele.repository;

import com.albee.mydataapi.api.base.tele.models.TeleContSearch;
import com.albee.mydataapi.api.base.tele.models.entity.TeleContEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeleContMapper{
    int insertTeleCont(TeleContEntity dom);

    int updateTeleCont(TeleContEntity dom);

    int deleteTeleCont(TeleContEntity dom);

    int deleteAllTeleCont(TeleContEntity dom);

    TeleContEntity selectTeleCont(TeleContSearch dom);

    Long selectTeleContListTotalCnt(TeleContSearch dom);

    List<TeleContEntity> selectTeleContList(TeleContSearch dom);
}
