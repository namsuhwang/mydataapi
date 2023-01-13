package com.kpcnc.mydataapi.api.load.tele.service;

import com.kpcnc.mydataapi.api.load.tele.models.TeleContSearch;
import com.kpcnc.mydataapi.api.load.tele.models.entity.TeleContEntity;
import com.kpcnc.mydataapi.api.load.tele.models.form.TeleContForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface TeleContService{
    public TeleContEntity regTeleCont(TeleContForm dom);

    public TeleContEntity modTeleCont(TeleContForm dom);

    public void  delTeleCont(TeleContForm dom);

    public TeleContEntity getTeleCont(TeleContSearch dom);

    public ResultListDto<TeleContEntity> getTeleContList(TeleContSearch dom);
}
