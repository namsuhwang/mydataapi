package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdMiBaseEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdMiBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdMiBaseSearch;

public interface InsuInsdMiBaseService{
    public void regInsuInsdMiBase(InsuInsdMiBaseForm dom);

    public void updInsuInsdMiBase(InsuInsdMiBaseForm dom);

    public void modInsuInsdMiBase(InsuInsdMiBaseForm dom);

    public void delInsuInsdMiBase(InsuInsdMiBaseForm dom);

    public InsuInsdMiBaseEntity getInsuInsdMiBase(InsuInsdMiBaseSearch dom);

    public ResultListDto<InsuInsdMiBaseEntity> getInsuInsdMiBaseList(InsuInsdMiBaseSearch dom);
}
