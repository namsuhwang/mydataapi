package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuMiService{
    public InsuMiEntity regInsuMi(InsuMiForm dom);

    public InsuMiEntity modInsuMi(InsuMiForm dom);

    public void  delInsuMi(InsuMiForm dom);

    public InsuMiEntity getInsuMi(InsuMiSearch dom);

    public ResultListDto<InsuMiEntity> getInsuMiList(InsuMiSearch dom);
}
