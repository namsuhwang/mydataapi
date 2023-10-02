package com.albee.mydataapi.api.base.tele.service;

import com.albee.mydataapi.api.base.tele.models.entity.TeleHistEntity;
import com.albee.mydataapi.api.base.tele.models.form.TeleHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.tele.models.TeleHistSearch;

public interface TeleHistService{
    public void regTeleHist(TeleHistForm dom);

    public void updTeleHist(TeleHistForm dom);

    public void modTeleHist(TeleHistForm dom);

    public void delTeleHist(TeleHistForm dom);

    public TeleHistEntity getTeleHist(TeleHistSearch dom);

    public TeleHistEntity getTeleHistLast(TeleHistSearch dom);

    public ResultListDto<TeleHistEntity> getTeleHistList(TeleHistSearch dom);
}
