package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdMiSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdMiEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdMiForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

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
