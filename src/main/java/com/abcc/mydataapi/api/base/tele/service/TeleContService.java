package com.abcc.mydataapi.api.base.tele.service;

import com.abcc.mydataapi.api.base.tele.models.entity.TeleContEntity;
import com.abcc.mydataapi.api.base.tele.models.form.TeleContForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.tele.models.TeleContSearch;

public interface TeleContService{
    public TeleContEntity regTeleCont(TeleContForm dom);

    public TeleContEntity modTeleCont(TeleContForm dom);

    public void  delTeleCont(TeleContForm dom);

    public TeleContEntity getTeleCont(TeleContSearch dom);

    public ResultListDto<TeleContEntity> getTeleContList(TeleContSearch dom);
}
