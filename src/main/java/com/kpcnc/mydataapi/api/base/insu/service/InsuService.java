package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuEntity;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuService{
    public InsuEntity regInsu(InsuForm dom);

    public InsuEntity modInsu(InsuForm dom);

    public void  delInsu(InsuForm dom);

    public InsuEntity getInsu(InsuSearch dom);

    public ResultListDto<InsuEntity> getInsuList(InsuSearch dom);
}
