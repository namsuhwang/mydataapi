package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdGurtSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdGurtEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdGurtForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuInsdGurtService{
    public InsuInsdGurtEntity regInsuInsdGurt(InsuInsdGurtForm dom);

    public InsuInsdGurtEntity modInsuInsdGurt(InsuInsdGurtForm dom);

    public void  delInsuInsdGurt(InsuInsdGurtForm dom);

    public InsuInsdGurtEntity getInsuInsdGurt(InsuInsdGurtSearch dom);

    public ResultListDto<InsuInsdGurtEntity> getInsuInsdGurtList(InsuInsdGurtSearch dom);
}
