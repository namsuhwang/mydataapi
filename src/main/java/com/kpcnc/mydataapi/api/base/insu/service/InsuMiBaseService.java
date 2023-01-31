package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiBaseSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiBaseEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

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
