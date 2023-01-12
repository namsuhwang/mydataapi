package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuGurtSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuGurtEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuGurtForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuGurtService{
    public InsuGurtEntity regInsuGurt(InsuGurtForm dom);

    public InsuGurtEntity modInsuGurt(InsuGurtForm dom);

    public void  delInsuGurt(InsuGurtForm dom);

    public InsuGurtEntity getInsuGurt(InsuGurtSearch dom);

    public ResultListDto<InsuGurtEntity> getInsuGurtList(InsuGurtSearch dom);
}
