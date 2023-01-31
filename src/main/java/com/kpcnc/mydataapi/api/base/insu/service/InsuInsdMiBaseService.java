package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdMiBaseSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdMiBaseEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdMiBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuInsdMiBaseService{
    public void regInsuInsdMiBase(InsuInsdMiBaseForm dom);

    public void updInsuInsdMiBase(InsuInsdMiBaseForm dom);

    public void modInsuInsdMiBase(InsuInsdMiBaseForm dom);

    public void delInsuInsdMiBase(InsuInsdMiBaseForm dom);

    public InsuInsdMiBaseEntity getInsuInsdMiBase(InsuInsdMiBaseSearch dom);

    public ResultListDto<InsuInsdMiBaseEntity> getInsuInsdMiBaseList(InsuInsdMiBaseSearch dom);
}
