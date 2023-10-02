package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuPayEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuPayForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuPaySearch;

public interface InsuPayService{
    public void regInsuPay(InsuPayForm dom);

    public void updInsuPay(InsuPayForm dom);

    public void modInsuPay(InsuPayForm dom);

    public void delInsuPay(InsuPayForm dom);

    public InsuPayEntity getInsuPay(InsuPaySearch dom);

    public ResultListDto<InsuPayEntity> getInsuPayList(InsuPaySearch dom);
}
