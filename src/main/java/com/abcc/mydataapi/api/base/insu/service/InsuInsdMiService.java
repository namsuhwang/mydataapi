package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdMiEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdMiForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdMiSearch;

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
