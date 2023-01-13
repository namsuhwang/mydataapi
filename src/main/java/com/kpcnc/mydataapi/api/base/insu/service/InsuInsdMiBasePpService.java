package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdMiBasePpSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdMiBasePpEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdMiBasePpForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuInsdMiBasePpService{
    public InsuInsdMiBasePpEntity regInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public InsuInsdMiBasePpEntity modInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public void  delInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public InsuInsdMiBasePpEntity getInsuInsdMiBasePp(InsuInsdMiBasePpSearch dom);

    public ResultListDto<InsuInsdMiBasePpEntity> getInsuInsdMiBasePpList(InsuInsdMiBasePpSearch dom);
}
