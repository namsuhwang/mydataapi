package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuMiBasePpEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuMiBasePpForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuMiBasePpSearch;

public interface InsuMiBasePpService{
    public void regInsuMiBasePp(InsuMiBasePpForm dom);

    public void updInsuMiBasePp(InsuMiBasePpForm dom);

    public void modInsuMiBasePp(InsuMiBasePpForm dom);

    public void  delInsuMiBasePp(InsuMiBasePpForm dom);

    public void  allDelInsuMiBasePp(InsuMiBasePpForm dom);

    public InsuMiBasePpEntity getInsuMiBasePp(InsuMiBasePpSearch dom);

    public ResultListDto<InsuMiBasePpEntity> getInsuMiBasePpList(InsuMiBasePpSearch dom);
}
