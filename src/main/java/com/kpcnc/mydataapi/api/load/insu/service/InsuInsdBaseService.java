package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdBaseEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuInsdBaseService{
    public InsuInsdBaseEntity regInsuInsdBase(InsuInsdBaseForm dom);

    public InsuInsdBaseEntity modInsuInsdBase(InsuInsdBaseForm dom);

    public void  delInsuInsdBase(InsuInsdBaseForm dom);

    public InsuInsdBaseEntity getInsuInsdBase(InsuInsdBaseSearch dom);

    public ResultListDto<InsuInsdBaseEntity> getInsuInsdBaseList(InsuInsdBaseSearch dom);
}
