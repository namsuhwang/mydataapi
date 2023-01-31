package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiBasePpSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiBasePpEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiBasePpForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuMiBasePpService{
    public void regInsuMiBasePp(InsuMiBasePpForm dom);

    public void updInsuMiBasePp(InsuMiBasePpForm dom);

    public void modInsuMiBasePp(InsuMiBasePpForm dom);

    public void  delInsuMiBasePp(InsuMiBasePpForm dom);

    public void  allDelInsuMiBasePp(InsuMiBasePpForm dom);

    public InsuMiBasePpEntity getInsuMiBasePp(InsuMiBasePpSearch dom);

    public ResultListDto<InsuMiBasePpEntity> getInsuMiBasePpList(InsuMiBasePpSearch dom);
}
