package com.kpcnc.mydataapi.api.base.tele.service;

import com.kpcnc.mydataapi.api.base.tele.models.TeleHistSearch;
import com.kpcnc.mydataapi.api.base.tele.models.entity.TeleHistEntity;
import com.kpcnc.mydataapi.api.base.tele.models.form.TeleHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface TeleHistService{
    public TeleHistEntity regTeleHist(TeleHistForm dom);

    public TeleHistEntity modTeleHist(TeleHistForm dom);

    public void  delTeleHist(TeleHistForm dom);

    public TeleHistEntity getTeleHist(TeleHistSearch dom);

    public ResultListDto<TeleHistEntity> getTeleHistList(TeleHistSearch dom);
}
