package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuMiEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuMiForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuMiSearch;

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
