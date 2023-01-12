package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuInsdService{
    public InsuInsdEntity regInsuInsd(InsuInsdForm dom);

    public InsuInsdEntity modInsuInsd(InsuInsdForm dom);

    public void  delInsuInsd(InsuInsdForm dom);

    public InsuInsdEntity getInsuInsd(InsuInsdSearch dom);

    public ResultListDto<InsuInsdEntity> getInsuInsdList(InsuInsdSearch dom);
}
