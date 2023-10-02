package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdBaseEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdBaseSearch;

public interface InsuInsdBaseService{
    public InsuInsdBaseEntity regInsuInsdBase(InsuInsdBaseForm dom);

    public InsuInsdBaseEntity modInsuInsdBase(InsuInsdBaseForm dom);

    public void  delInsuInsdBase(InsuInsdBaseForm dom);

    public InsuInsdBaseEntity getInsuInsdBase(InsuInsdBaseSearch dom);

    public ResultListDto<InsuInsdBaseEntity> getInsuInsdBaseList(InsuInsdBaseSearch dom);
}
