package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.InsuMiBasePpEntity;
import com.kpcnc.mydataapi.api.load.insu.models.InsuMiBasePpSearch;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuMiBasePpForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuMiBasePpService{
    public InsuMiBasePpEntity regInsuMiBasePp(InsuMiBasePpForm dom);

    public InsuMiBasePpEntity modInsuMiBasePp(InsuMiBasePpForm dom);

    public void  delInsuMiBasePp(InsuMiBasePpForm dom);

    public InsuMiBasePpEntity getInsuMiBasePp(InsuMiBasePpSearch dom);

    public ResultListDto<InsuMiBasePpEntity> getInsuMiBasePpList(InsuMiBasePpSearch dom);
}
