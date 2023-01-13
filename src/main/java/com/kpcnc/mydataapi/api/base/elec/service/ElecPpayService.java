package com.kpcnc.mydataapi.api.base.elec.service;

import com.kpcnc.mydataapi.api.base.elec.models.ElecPpaySearch;
import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPpayEntity;
import com.kpcnc.mydataapi.api.base.elec.models.form.ElecPpayForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface ElecPpayService{
    public ElecPpayEntity regElecPpay(ElecPpayForm dom);

    public ElecPpayEntity modElecPpay(ElecPpayForm dom);

    public void  delElecPpay(ElecPpayForm dom);

    public ElecPpayEntity getElecPpay(ElecPpaySearch dom);

    public ResultListDto<ElecPpayEntity> getElecPpayList(ElecPpaySearch dom);
}
