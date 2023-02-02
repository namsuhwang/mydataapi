package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuBaseEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuBaseSearch;

public interface InsuBaseService{
    public void regInsuBase(InsuBaseForm dom);

    public void updInsuBase(InsuBaseForm dom);

    public void modInsuBase(InsuBaseForm dom);

    public void  delInsuBase(InsuBaseForm dom);

    public void  allDelInsuBase(InsuBaseForm dom);

    public InsuBaseEntity getInsuBase(InsuBaseSearch dom);

    public ResultListDto<InsuBaseEntity> getInsuBaseList(InsuBaseSearch dom);
}
