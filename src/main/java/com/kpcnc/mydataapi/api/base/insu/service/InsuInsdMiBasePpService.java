package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdMiBasePpSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdMiBasePpEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdMiBasePpForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuInsdMiBasePpService{
    public void regInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public void updInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public void modInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public void  delInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public void  allDelInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public InsuInsdMiBasePpEntity getInsuInsdMiBasePp(InsuInsdMiBasePpSearch dom);

    public ResultListDto<InsuInsdMiBasePpEntity> getInsuInsdMiBasePpList(InsuInsdMiBasePpSearch dom);
}
