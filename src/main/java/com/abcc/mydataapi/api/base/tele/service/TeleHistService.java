package com.abcc.mydataapi.api.base.tele.service;

import com.abcc.mydataapi.api.base.tele.models.entity.TeleHistEntity;
import com.abcc.mydataapi.api.base.tele.models.form.TeleHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.tele.models.TeleHistSearch;

public interface TeleHistService{
    public TeleHistEntity regTeleHist(TeleHistForm dom);

    public TeleHistEntity modTeleHist(TeleHistForm dom);

    public void  delTeleHist(TeleHistForm dom);

    public TeleHistEntity getTeleHist(TeleHistSearch dom);

    public ResultListDto<TeleHistEntity> getTeleHistList(TeleHistSearch dom);
}
