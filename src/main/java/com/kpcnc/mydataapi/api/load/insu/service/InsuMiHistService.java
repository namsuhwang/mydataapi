package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuMiHistSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuMiHistEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuMiHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuMiHistService{
    public InsuMiHistEntity regInsuMiHist(InsuMiHistForm dom);

    public InsuMiHistEntity modInsuMiHist(InsuMiHistForm dom);

    public void  delInsuMiHist(InsuMiHistForm dom);

    public InsuMiHistEntity getInsuMiHist(InsuMiHistSearch dom);

    public ResultListDto<InsuMiHistEntity> getInsuMiHistList(InsuMiHistSearch dom);
}
