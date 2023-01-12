package com.kpcnc.mydataapi.api.load.elec.service;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPpayAccSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayAccEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayAccForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ElecPpayAccService{
    public ElecPpayAccEntity regElecPpayAcc(ElecPpayAccForm dom);

    public ElecPpayAccEntity modElecPpayAcc(ElecPpayAccForm dom);

    public void  delElecPpayAcc(ElecPpayAccForm dom);

    public ElecPpayAccEntity getElecPpayAcc(ElecPpayAccSearch dom);

    public ResultListDto<ElecPpayAccEntity> getElecPpayAccList(ElecPpayAccSearch dom);
}
