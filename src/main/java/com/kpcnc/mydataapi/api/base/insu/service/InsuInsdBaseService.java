package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdBaseSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdBaseEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuInsdBaseService{
    public InsuInsdBaseEntity regInsuInsdBase(InsuInsdBaseForm dom);

    public InsuInsdBaseEntity modInsuInsdBase(InsuInsdBaseForm dom);

    public void  delInsuInsdBase(InsuInsdBaseForm dom);

    public InsuInsdBaseEntity getInsuInsdBase(InsuInsdBaseSearch dom);

    public ResultListDto<InsuInsdBaseEntity> getInsuInsdBaseList(InsuInsdBaseSearch dom);
}
