package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuMiPayEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuMiPayForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuMiPaySearch;

public interface InsuMiPayService{
    public InsuMiPayEntity regInsuMiPay(InsuMiPayForm dom);

    public InsuMiPayEntity modInsuMiPay(InsuMiPayForm dom);

    public void  delInsuMiPay(InsuMiPayForm dom);

    public InsuMiPayEntity getInsuMiPay(InsuMiPaySearch dom);

    public ResultListDto<InsuMiPayEntity> getInsuMiPayList(InsuMiPaySearch dom);
}
