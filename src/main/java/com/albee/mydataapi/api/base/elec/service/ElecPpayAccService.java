package com.albee.mydataapi.api.base.elec.service;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayAccEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayAccForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPpayAccSearch;

public interface ElecPpayAccService{
    public void regElecPpayAcc(ElecPpayAccForm dom);

    public void updElecPpayAcc(ElecPpayAccForm dom);

    public void modElecPpayAcc(ElecPpayAccForm dom);

    public void delElecPpayAcc(ElecPpayAccForm dom);

    public ElecPpayAccEntity getElecPpayAcc(ElecPpayAccSearch dom);

    public ResultListDto<ElecPpayAccEntity> getElecPpayAccList(ElecPpayAccSearch dom);
}
