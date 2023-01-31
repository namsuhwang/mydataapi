package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuHistSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuHistEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuHistService{
    public void regInsuHist(InsuHistForm dom);

    public void updInsuHist(InsuHistForm dom);

    public void modInsuHist(InsuHistForm dom);

    public void delInsuHist(InsuHistForm dom);

    public InsuHistEntity getInsuHist(InsuHistSearch dom);

    public InsuHistEntity getInsuHistLast(InsuHistSearch dom);

    public ResultListDto<InsuHistEntity> getInsuHistList(InsuHistSearch dom);
}
