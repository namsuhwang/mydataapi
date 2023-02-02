package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuMiEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuMiForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuMiSearch;

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
