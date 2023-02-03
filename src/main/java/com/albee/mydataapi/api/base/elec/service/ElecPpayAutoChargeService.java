package com.albee.mydataapi.api.base.elec.service;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayAutoChargeEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayAutoChargeForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPpayAutoChargeSearch;

public interface ElecPpayAutoChargeService{
    public void regElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public void updElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public void modElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public void delElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public void allDelElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public ElecPpayAutoChargeEntity getElecPpayAutoCharge(ElecPpayAutoChargeSearch dom);

    public ElecPpayAutoChargeEntity getElecPpayAutoChargeLast(ElecPpayAutoChargeSearch dom);

    public ResultListDto<ElecPpayAutoChargeEntity> getElecPpayAutoChargeList(ElecPpayAutoChargeSearch dom);
}
