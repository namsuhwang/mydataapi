package com.albee.mydataapi.api.base.elec.service;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPpaySearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayForm;

public interface ElecPpayService{
    public void regElecPpay(ElecPpayForm dom);

    public void updElecPpay(ElecPpayForm dom);

    public void modElecPpay(ElecPpayForm dom);

    public void delElecPpay(ElecPpayForm dom);

    public void allDelElecPpay(ElecPpayForm dom);

    public ElecPpayEntity getElecPpay(ElecPpaySearch dom);

    public ResultListDto<ElecPpayEntity> getElecPpayList(ElecPpaySearch dom);
}
