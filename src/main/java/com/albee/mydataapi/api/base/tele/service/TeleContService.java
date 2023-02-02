package com.albee.mydataapi.api.base.tele.service;

import com.albee.mydataapi.api.base.tele.models.entity.TeleContEntity;
import com.albee.mydataapi.api.base.tele.models.form.TeleContForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.tele.models.TeleContSearch;

public interface TeleContService{
    public TeleContEntity regTeleCont(TeleContForm dom);

    public TeleContEntity modTeleCont(TeleContForm dom);

    public void  delTeleCont(TeleContForm dom);

    public TeleContEntity getTeleCont(TeleContSearch dom);

    public ResultListDto<TeleContEntity> getTeleContList(TeleContSearch dom);
}
