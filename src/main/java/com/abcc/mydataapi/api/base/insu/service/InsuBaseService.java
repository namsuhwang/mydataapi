package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuBaseEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuBaseForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuBaseSearch;

public interface InsuBaseService{
    public void regInsuBase(InsuBaseForm dom);

    public void updInsuBase(InsuBaseForm dom);

    public void modInsuBase(InsuBaseForm dom);

    public void  delInsuBase(InsuBaseForm dom);

    public void  allDelInsuBase(InsuBaseForm dom);

    public InsuBaseEntity getInsuBase(InsuBaseSearch dom);

    public ResultListDto<InsuBaseEntity> getInsuBaseList(InsuBaseSearch dom);
}
