package com.kpcnc.mydataapi.api.load.elec.service;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPpayHistSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayHistEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ElecPpayHistService{
    public ElecPpayHistEntity regElecPpayHist(ElecPpayHistForm dom);

    public ElecPpayHistEntity modElecPpayHist(ElecPpayHistForm dom);

    public void  delElecPpayHist(ElecPpayHistForm dom);

    public ElecPpayHistEntity getElecPpayHist(ElecPpayHistSearch dom);

    public ResultListDto<ElecPpayHistEntity> getElecPpayHistList(ElecPpayHistSearch dom);
}
