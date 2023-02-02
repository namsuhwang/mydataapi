package com.abcc.mydataapi.api.base.elec.service;

import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayHistEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPpayHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.elec.models.ElecPpayHistSearch;

public interface ElecPpayHistService{
    public ElecPpayHistEntity regElecPpayHist(ElecPpayHistForm dom);

    public ElecPpayHistEntity modElecPpayHist(ElecPpayHistForm dom);

    public void  delElecPpayHist(ElecPpayHistForm dom);

    public ElecPpayHistEntity getElecPpayHist(ElecPpayHistSearch dom);

    public ResultListDto<ElecPpayHistEntity> getElecPpayHistList(ElecPpayHistSearch dom);
}
