package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuMiHistEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuMiHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuMiHistSearch;

public interface InsuMiHistService{
    public void regInsuMiHist(InsuMiHistForm dom);

    public void updInsuMiHist(InsuMiHistForm dom);

    public void modInsuMiHist(InsuMiHistForm dom);

    public void  delInsuMiHist(InsuMiHistForm dom);

    public InsuMiHistEntity getInsuMiHist(InsuMiHistSearch dom);

    public InsuMiHistEntity getInsuMiHistLast(InsuMiHistSearch dom);

    public ResultListDto<InsuMiHistEntity> getInsuMiHistList(InsuMiHistSearch dom);
}
