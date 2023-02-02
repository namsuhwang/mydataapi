package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuMiBaseEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuMiBaseForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuMiBaseSearch;

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
