package com.abcc.mydataapi.api.base.elec.service;

import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayAccEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPpayAccForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.elec.models.ElecPpayAccSearch;

public interface ElecPpayAccService{
    public ElecPpayAccEntity regElecPpayAcc(ElecPpayAccForm dom);

    public ElecPpayAccEntity modElecPpayAcc(ElecPpayAccForm dom);

    public void  delElecPpayAcc(ElecPpayAccForm dom);

    public ElecPpayAccEntity getElecPpayAcc(ElecPpayAccSearch dom);

    public ResultListDto<ElecPpayAccEntity> getElecPpayAccList(ElecPpayAccSearch dom);
}
