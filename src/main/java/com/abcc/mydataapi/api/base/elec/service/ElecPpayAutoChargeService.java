package com.abcc.mydataapi.api.base.elec.service;

import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayAutoChargeEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPpayAutoChargeForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.elec.models.ElecPpayAutoChargeSearch;

public interface ElecPpayAutoChargeService{
    public ElecPpayAutoChargeEntity regElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public ElecPpayAutoChargeEntity modElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public void  delElecPpayAutoCharge(ElecPpayAutoChargeForm dom);

    public ElecPpayAutoChargeEntity getElecPpayAutoCharge(ElecPpayAutoChargeSearch dom);

    public ResultListDto<ElecPpayAutoChargeEntity> getElecPpayAutoChargeList(ElecPpayAutoChargeSearch dom);
}
