package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdSearch;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdForm;

public interface InsuInsdService{
    public void regInsuInsd(InsuInsdForm dom);

    public void updInsuInsd(InsuInsdForm dom);

    public void modInsuInsd(InsuInsdForm dom);

    public void  delInsuInsd(InsuInsdForm dom);

    public void  allDelInsuInsd(InsuInsdForm dom);

    public InsuInsdEntity getInsuInsd(InsuInsdSearch dom);

    public InsuInsdEntity getInsuInsdLast(InsuInsdSearch dom);

    public ResultListDto<InsuInsdEntity> getInsuInsdList(InsuInsdSearch dom);
}
