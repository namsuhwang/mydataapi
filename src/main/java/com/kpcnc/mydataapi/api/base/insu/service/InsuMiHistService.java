package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiHistSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiHistEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuMiHistService{
    public InsuMiHistEntity regInsuMiHist(InsuMiHistForm dom);

    public InsuMiHistEntity modInsuMiHist(InsuMiHistForm dom);

    public void  delInsuMiHist(InsuMiHistForm dom);

    public InsuMiHistEntity getInsuMiHist(InsuMiHistSearch dom);

    public ResultListDto<InsuMiHistEntity> getInsuMiHistList(InsuMiHistSearch dom);
}
