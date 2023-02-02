package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuPayEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuPayForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuPaySearch;

public interface InsuPayService{
    public void regInsuPay(InsuPayForm dom);

    public void updInsuPay(InsuPayForm dom);

    public void modInsuPay(InsuPayForm dom);

    public void delInsuPay(InsuPayForm dom);

    public InsuPayEntity getInsuPay(InsuPaySearch dom);

    public ResultListDto<InsuPayEntity> getInsuPayList(InsuPaySearch dom);
}
