package com.kpcnc.mydataapi.api.load.tele.service;

import com.kpcnc.mydataapi.api.load.tele.models.TelePaySearch;
import com.kpcnc.mydataapi.api.load.tele.models.entity.TelePayEntity;
import com.kpcnc.mydataapi.api.load.tele.models.form.TelePayForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface TelePayService{
    public TelePayEntity regTelePay(TelePayForm dom);

    public TelePayEntity modTelePay(TelePayForm dom);

    public void  delTelePay(TelePayForm dom);

    public TelePayEntity getTelePay(TelePaySearch dom);

    public ResultListDto<TelePayEntity> getTelePayList(TelePaySearch dom);
}
