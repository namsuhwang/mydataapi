package com.abcc.mydataapi.api.base.tele.service;

import com.abcc.mydataapi.api.base.tele.models.entity.TeleChargeEntity;
import com.abcc.mydataapi.api.base.tele.models.form.TeleChargeForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.tele.models.TeleChargeSearch;

public interface TeleChargeService{
    public TeleChargeEntity regTeleCharge(TeleChargeForm dom);

    public TeleChargeEntity modTeleCharge(TeleChargeForm dom);

    public void  delTeleCharge(TeleChargeForm dom);

    public TeleChargeEntity getTeleCharge(TeleChargeSearch dom);

    public ResultListDto<TeleChargeEntity> getTeleChargeList(TeleChargeSearch dom);
}
