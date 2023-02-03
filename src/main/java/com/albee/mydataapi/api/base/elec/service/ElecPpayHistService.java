package com.albee.mydataapi.api.base.elec.service;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayHistEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPpayHistSearch;

public interface ElecPpayHistService{
    public void regElecPpayHist(ElecPpayHistForm dom);

    public void updElecPpayHist(ElecPpayHistForm dom);

    public void modElecPpayHist(ElecPpayHistForm dom);

    public void delElecPpayHist(ElecPpayHistForm dom);

    public ElecPpayHistEntity getElecPpayHist(ElecPpayHistSearch dom);

    public ElecPpayHistEntity getElecPpayHistLast(ElecPpayHistSearch dom);

    public ResultListDto<ElecPpayHistEntity> getElecPpayHistList(ElecPpayHistSearch dom);
}
