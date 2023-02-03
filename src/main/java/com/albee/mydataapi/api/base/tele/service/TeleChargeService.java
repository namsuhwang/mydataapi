package com.albee.mydataapi.api.base.tele.service;

import com.albee.mydataapi.api.base.tele.models.entity.TeleChargeEntity;
import com.albee.mydataapi.api.base.tele.models.form.TeleChargeForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.tele.models.TeleChargeSearch;

public interface TeleChargeService{
    public void regTeleCharge(TeleChargeForm dom);

    public void updTeleCharge(TeleChargeForm dom);

    public void modTeleCharge(TeleChargeForm dom);

    public void delTeleCharge(TeleChargeForm dom);

    public TeleChargeEntity getTeleCharge(TeleChargeSearch dom);

    public TeleChargeEntity getTeleChargeLast(TeleChargeSearch dom);

    public ResultListDto<TeleChargeEntity> getTeleChargeList(TeleChargeSearch dom);
}
