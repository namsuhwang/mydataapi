package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuBaseInsdEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuBaseInsdForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuBaseInsdSearch;

public interface InsuBaseInsdService{
    public void regInsuBaseInsd(InsuBaseInsdForm dom);

    public void updInsuBaseInsd(InsuBaseInsdForm dom);

    public void modInsuBaseInsd(InsuBaseInsdForm dom);

    public void  delInsuBaseInsd(InsuBaseInsdForm dom);

    public void  allDelInsuBaseInsd(InsuBaseInsdForm dom);

    public InsuBaseInsdEntity getInsuBaseInsd(InsuBaseInsdSearch dom);

    public ResultListDto<InsuBaseInsdEntity> getInsuBaseInsdList(InsuBaseInsdSearch dom);
}
