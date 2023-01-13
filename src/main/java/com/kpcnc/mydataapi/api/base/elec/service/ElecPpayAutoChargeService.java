package com.kpcnc.mydataapi.api.base.elec.service;

import com.kpcnc.mydataapi.api.ElecPpayAutoChargeSearch;
import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPpayAutoChargeEntity;
import com.kpcnc.mydataapi.api.base.elec.models.form.ElecPpayAutoChargeForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface ElecPpayAutoChargeService{
    public ElecPpayAutoChargeEntity regElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public ElecPpayAutoChargeEntity modElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public void  delElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public ElecPpayAutoChargeEntity getElecPpayAutoCharge(ElecPpayAutoChargeSearch dom);

    public ResultListDto<ElecPpayAutoChargeEntity> getElecPpayAutoChargeList(ElecPpayAutoChargeSearch dom);
}
