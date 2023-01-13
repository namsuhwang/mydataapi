package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiBaseSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiBaseEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuMiBaseService{
    public InsuMiBaseEntity regInsuMiBase(InsuMiBaseForm dom);

    public InsuMiBaseEntity modInsuMiBase(InsuMiBaseForm dom);

    public void  delInsuMiBase(InsuMiBaseForm dom);

    public InsuMiBaseEntity getInsuMiBase(InsuMiBaseSearch dom);

    public ResultListDto<InsuMiBaseEntity> getInsuMiBaseList(InsuMiBaseSearch dom);
}
