package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuHistEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuHistSearch;

public interface InsuHistService{
    public void regInsuHist(InsuHistForm dom);

    public void updInsuHist(InsuHistForm dom);

    public void modInsuHist(InsuHistForm dom);

    public void delInsuHist(InsuHistForm dom);

    public InsuHistEntity getInsuHist(InsuHistSearch dom);

    public InsuHistEntity getInsuHistLast(InsuHistSearch dom);

    public ResultListDto<InsuHistEntity> getInsuHistList(InsuHistSearch dom);
}
