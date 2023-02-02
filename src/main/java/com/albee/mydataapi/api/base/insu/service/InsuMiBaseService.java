package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuMiBaseEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuMiBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuMiBaseSearch;

public interface InsuMiBaseService{
    public void regInsuMiBase(InsuMiBaseForm dom);

    public void updInsuMiBase(InsuMiBaseForm dom);

    public void modInsuMiBase(InsuMiBaseForm dom);

    public void  delInsuMiBase(InsuMiBaseForm dom);

    public void  allDelInsuMiBase(InsuMiBaseForm dom);

    public InsuMiBaseEntity getInsuMiBase(InsuMiBaseSearch dom);

    public InsuMiBaseEntity getInsuMiBaseLast(InsuMiBaseSearch dom);

    public ResultListDto<InsuMiBaseEntity> getInsuMiBaseList(InsuMiBaseSearch dom);
}
