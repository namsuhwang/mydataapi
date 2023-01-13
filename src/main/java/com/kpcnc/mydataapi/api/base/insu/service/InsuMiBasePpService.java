package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.InsuMiBasePpEntity;
import com.kpcnc.mydataapi.api.base.insu.models.InsuMiBasePpSearch;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuMiBasePpForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuMiBasePpService{
    public InsuMiBasePpEntity regInsuMiBasePp(InsuMiBasePpForm dom);

    public InsuMiBasePpEntity modInsuMiBasePp(InsuMiBasePpForm dom);

    public void  delInsuMiBasePp(InsuMiBasePpForm dom);

    public InsuMiBasePpEntity getInsuMiBasePp(InsuMiBasePpSearch dom);

    public ResultListDto<InsuMiBasePpEntity> getInsuMiBasePpList(InsuMiBasePpSearch dom);
}
