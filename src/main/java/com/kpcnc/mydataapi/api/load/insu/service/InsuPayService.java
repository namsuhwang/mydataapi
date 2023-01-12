package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuPaySearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuPayEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuPayForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuPayService{
    public InsuPayEntity regInsuPay(InsuPayForm dom);

    public InsuPayEntity modInsuPay(InsuPayForm dom);

    public void  delInsuPay(InsuPayForm dom);

    public InsuPayEntity getInsuPay(InsuPaySearch dom);

    public ResultListDto<InsuPayEntity> getInsuPayList(InsuPaySearch dom);
}
