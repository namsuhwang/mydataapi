package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiBaseEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdMiBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuInsdMiBaseService{
    public InsuInsdMiBaseEntity regInsuInsdMiBase(InsuInsdMiBaseForm dom);

    public InsuInsdMiBaseEntity modInsuInsdMiBase(InsuInsdMiBaseForm dom);

    public void  delInsuInsdMiBase(InsuInsdMiBaseForm dom);

    public InsuInsdMiBaseEntity getInsuInsdMiBase(InsuInsdMiBaseSearch dom);

    public ResultListDto<InsuInsdMiBaseEntity> getInsuInsdMiBaseList(InsuInsdMiBaseSearch dom);
}
