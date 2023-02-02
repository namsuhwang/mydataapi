package com.abcc.mydataapi.api.base.elec.service;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.elec.models.ElecPpaySearch;
import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPpayForm;

public interface ElecPpayService{
    public ElecPpayEntity regElecPpay(ElecPpayForm dom);

    public ElecPpayEntity modElecPpay(ElecPpayForm dom);

    public void  delElecPpay(ElecPpayForm dom);

    public ElecPpayEntity getElecPpay(ElecPpaySearch dom);

    public ResultListDto<ElecPpayEntity> getElecPpayList(ElecPpaySearch dom);
}
