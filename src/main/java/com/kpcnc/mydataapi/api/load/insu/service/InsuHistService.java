package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuHistSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuHistEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuHistService{
    public InsuHistEntity regInsuHist(InsuHistForm dom);

    public InsuHistEntity modInsuHist(InsuHistForm dom);

    public void  delInsuHist(InsuHistForm dom);

    public InsuHistEntity getInsuHist(InsuHistSearch dom);

    public ResultListDto<InsuHistEntity> getInsuHistList(InsuHistSearch dom);
}
