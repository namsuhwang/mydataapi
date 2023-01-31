package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuMiService{
    public void regInsuMi(InsuMiForm dom);

    public void updInsuMi(InsuMiForm dom);

    public void modInsuMi(InsuMiForm dom);

    public void delInsuMi(InsuMiForm dom);

    public void allDelInsuMi(InsuMiForm dom);

    public InsuMiEntity getInsuMi(InsuMiSearch dom);

    public InsuMiEntity getInsuMiLast(InsuMiSearch dom);

    public ResultListDto<InsuMiEntity> getInsuMiList(InsuMiSearch dom);
}
