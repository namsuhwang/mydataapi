package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdMiEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdMiForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdMiSearch;

public interface InsuInsdMiService{
    public void regInsuInsdMi(InsuInsdMiForm dom);

    public void updInsuInsdMi(InsuInsdMiForm dom);

    public void modInsuInsdMi(InsuInsdMiForm dom);

    public void delInsuInsdMi(InsuInsdMiForm dom);

    public void allDelInsuInsdMi(InsuInsdMiForm dom);

    public InsuInsdMiEntity getInsuInsdMi(InsuInsdMiSearch dom);

    public InsuInsdMiEntity getInsuInsdMiLast(InsuInsdMiSearch dom);

    public ResultListDto<InsuInsdMiEntity> getInsuInsdMiList(InsuInsdMiSearch dom);
}
