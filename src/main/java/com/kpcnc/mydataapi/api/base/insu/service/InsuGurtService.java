package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuGurtSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuGurtEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuGurtForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuGurtService{
    public InsuGurtEntity regInsuGurt(InsuGurtForm dom);

    public InsuGurtEntity modInsuGurt(InsuGurtForm dom);

    public void  delInsuGurt(InsuGurtForm dom);

    public InsuGurtEntity getInsuGurt(InsuGurtSearch dom);

    public ResultListDto<InsuGurtEntity> getInsuGurtList(InsuGurtSearch dom);
}