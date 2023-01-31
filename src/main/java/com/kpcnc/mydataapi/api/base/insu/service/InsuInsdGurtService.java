package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdGurtSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdGurtEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdGurtForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuInsdGurtService{
    public void regInsuInsdGurt(InsuInsdGurtForm dom);

    public void updInsuInsdGurt(InsuInsdGurtForm dom);

    public void modInsuInsdGurt(InsuInsdGurtForm dom);

    public void  delInsuInsdGurt(InsuInsdGurtForm dom);

    public void allDelInsuInsdGurt(InsuInsdGurtForm dom);

    public InsuInsdGurtEntity getInsuInsdGurt(InsuInsdGurtSearch dom);

    public InsuInsdGurtEntity getInsuInsdGurtLast(InsuInsdGurtSearch dom);

    public ResultListDto<InsuInsdGurtEntity> getInsuInsdGurtList(InsuInsdGurtSearch dom);
}
