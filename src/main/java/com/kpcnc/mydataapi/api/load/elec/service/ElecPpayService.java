package com.kpcnc.mydataapi.api.load.elec.service;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPpaySearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ElecPpayService{
    public ElecPpayEntity regElecPpay(ElecPpayForm dom);

    public ElecPpayEntity modElecPpay(ElecPpayForm dom);

    public void  delElecPpay(ElecPpayForm dom);

    public ElecPpayEntity getElecPpay(ElecPpaySearch dom);

    public ResultListDto<ElecPpayEntity> getElecPpayList(ElecPpaySearch dom);
}
