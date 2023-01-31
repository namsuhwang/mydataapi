package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

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
