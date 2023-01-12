package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuMiPaySearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuMiPayEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuMiPayForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuMiPayService{
    public InsuMiPayEntity regInsuMiPay(InsuMiPayForm dom);

    public InsuMiPayEntity modInsuMiPay(InsuMiPayForm dom);

    public void  delInsuMiPay(InsuMiPayForm dom);

    public InsuMiPayEntity getInsuMiPay(InsuMiPaySearch dom);

    public ResultListDto<InsuMiPayEntity> getInsuMiPayList(InsuMiPaySearch dom);
}
