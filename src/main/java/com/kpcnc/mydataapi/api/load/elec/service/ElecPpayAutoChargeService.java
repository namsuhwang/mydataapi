package com.kpcnc.mydataapi.api.load.elec.service;

import com.kpcnc.mydataapi.api.ElecPpayAutoChargeSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayAutoChargeEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayAutoChargeForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ElecPpayAutoChargeService{
    public ElecPpayAutoChargeEntity regElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public ElecPpayAutoChargeEntity modElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public void  delElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public ElecPpayAutoChargeEntity getElecPpayAutoCharge(ElecPpayAutoChargeSearch dom);

    public ResultListDto<ElecPpayAutoChargeEntity> getElecPpayAutoChargeList(ElecPpayAutoChargeSearch dom);
}
