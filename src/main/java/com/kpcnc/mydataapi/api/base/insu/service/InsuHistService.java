package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuHistSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuHistEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuHistService{
    public InsuHistEntity regInsuHist(InsuHistForm dom);

    public InsuHistEntity modInsuHist(InsuHistForm dom);

    public void  delInsuHist(InsuHistForm dom);

    public InsuHistEntity getInsuHist(InsuHistSearch dom);

    public ResultListDto<InsuHistEntity> getInsuHistList(InsuHistSearch dom);
}
