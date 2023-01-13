package com.kpcnc.mydataapi.api.base.tele.service;

import com.kpcnc.mydataapi.api.base.tele.models.TeleChargeSearch;
import com.kpcnc.mydataapi.api.base.tele.models.entity.TeleChargeEntity;
import com.kpcnc.mydataapi.api.base.tele.models.form.TeleChargeForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface TeleChargeService{
    public TeleChargeEntity regTeleCharge(TeleChargeForm dom);

    public TeleChargeEntity modTeleCharge(TeleChargeForm dom);

    public void  delTeleCharge(TeleChargeForm dom);

    public TeleChargeEntity getTeleCharge(TeleChargeSearch dom);

    public ResultListDto<TeleChargeEntity> getTeleChargeList(TeleChargeSearch dom);
}
