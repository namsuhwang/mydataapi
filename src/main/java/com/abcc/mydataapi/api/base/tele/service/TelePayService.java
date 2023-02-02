package com.abcc.mydataapi.api.base.tele.service;

import com.abcc.mydataapi.api.base.tele.models.entity.TelePayEntity;
import com.abcc.mydataapi.api.base.tele.models.form.TelePayForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.tele.models.TelePaySearch;

public interface TelePayService{
    public TelePayEntity regTelePay(TelePayForm dom);

    public TelePayEntity modTelePay(TelePayForm dom);

    public void  delTelePay(TelePayForm dom);

    public TelePayEntity getTelePay(TelePaySearch dom);

    public ResultListDto<TelePayEntity> getTelePayList(TelePaySearch dom);
}
