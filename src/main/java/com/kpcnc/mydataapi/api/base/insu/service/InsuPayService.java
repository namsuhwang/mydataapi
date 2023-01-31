package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuPaySearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuPayEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuPayForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuPayService{
    public void regInsuPay(InsuPayForm dom);

    public void updInsuPay(InsuPayForm dom);

    public void modInsuPay(InsuPayForm dom);

    public void delInsuPay(InsuPayForm dom);

    public InsuPayEntity getInsuPay(InsuPaySearch dom);

    public ResultListDto<InsuPayEntity> getInsuPayList(InsuPaySearch dom);
}
