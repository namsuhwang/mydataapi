package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdMiBasePpEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdMiBasePpForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdMiBasePpSearch;

public interface InsuInsdMiBasePpService{
    public void regInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public void updInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public void modInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public void  delInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public void  allDelInsuInsdMiBasePp(InsuInsdMiBasePpForm dom);

    public InsuInsdMiBasePpEntity getInsuInsdMiBasePp(InsuInsdMiBasePpSearch dom);

    public ResultListDto<InsuInsdMiBasePpEntity> getInsuInsdMiBasePpList(InsuInsdMiBasePpSearch dom);
}
