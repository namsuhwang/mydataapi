package com.kpcnc.mydataapi.api.base.elec.service;

import com.kpcnc.mydataapi.api.base.elec.models.ElecPpayHistSearch;
import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPpayHistEntity;
import com.kpcnc.mydataapi.api.base.elec.models.form.ElecPpayHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface ElecPpayHistService{
    public ElecPpayHistEntity regElecPpayHist(ElecPpayHistForm dom);

    public ElecPpayHistEntity modElecPpayHist(ElecPpayHistForm dom);

    public void  delElecPpayHist(ElecPpayHistForm dom);

    public ElecPpayHistEntity getElecPpayHist(ElecPpayHistSearch dom);

    public ResultListDto<ElecPpayHistEntity> getElecPpayHistList(ElecPpayHistSearch dom);
}
