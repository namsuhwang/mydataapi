package com.kpcnc.mydataapi.api.load.tele.service;

import com.kpcnc.mydataapi.api.load.tele.models.TeleHistSearch;
import com.kpcnc.mydataapi.api.load.tele.models.entity.TeleHistEntity;
import com.kpcnc.mydataapi.api.load.tele.models.form.TeleHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface TeleHistService{
    public TeleHistEntity regTeleHist(TeleHistForm dom);

    public TeleHistEntity modTeleHist(TeleHistForm dom);

    public void  delTeleHist(TeleHistForm dom);

    public TeleHistEntity getTeleHist(TeleHistSearch dom);

    public ResultListDto<TeleHistEntity> getTeleHistList(TeleHistSearch dom);
}
