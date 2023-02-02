package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdGurtEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdGurtForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdGurtSearch;

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
