package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdGurtSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdGurtEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdGurtForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuInsdGurtService{
    public InsuInsdGurtEntity regInsuInsdGurt(InsuInsdGurtForm dom);

    public InsuInsdGurtEntity modInsuInsdGurt(InsuInsdGurtForm dom);

    public void  delInsuInsdGurt(InsuInsdGurtForm dom);

    public InsuInsdGurtEntity getInsuInsdGurt(InsuInsdGurtSearch dom);

    public ResultListDto<InsuInsdGurtEntity> getInsuInsdGurtList(InsuInsdGurtSearch dom);
}
