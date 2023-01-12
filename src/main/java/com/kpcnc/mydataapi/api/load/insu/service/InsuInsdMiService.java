package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdMiForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuInsdMiService{
    public InsuInsdMiEntity regInsuInsdMi(InsuInsdMiForm dom);

    public InsuInsdMiEntity modInsuInsdMi(InsuInsdMiForm dom);

    public void  delInsuInsdMi(InsuInsdMiForm dom);

    public InsuInsdMiEntity getInsuInsdMi(InsuInsdMiSearch dom);

    public ResultListDto<InsuInsdMiEntity> getInsuInsdMiList(InsuInsdMiSearch dom);
}
