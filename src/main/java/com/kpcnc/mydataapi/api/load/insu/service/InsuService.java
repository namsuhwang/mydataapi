package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuEntity;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuService{
    public InsuEntity regInsu(InsuForm dom);

    public InsuEntity modInsu(InsuForm dom);

    public void  delInsu(InsuForm dom);

    public InsuEntity getInsu(InsuSearch dom);

    public ResultListDto<InsuEntity> getInsuList(InsuSearch dom);
}
