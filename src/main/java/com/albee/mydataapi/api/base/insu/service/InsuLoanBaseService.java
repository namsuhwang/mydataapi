package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanBaseEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuLoanBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuLoanBaseSearch;

public interface InsuLoanBaseService{
    public void regInsuLoanBase(InsuLoanBaseForm dom);

    public void updInsuLoanBase(InsuLoanBaseForm dom);

    public void modInsuLoanBase(InsuLoanBaseForm dom);

    public void  delInsuLoanBase(InsuLoanBaseForm dom);

    public InsuLoanBaseEntity getInsuLoanBase(InsuLoanBaseSearch dom);

    public ResultListDto<InsuLoanBaseEntity> getInsuLoanBaseList(InsuLoanBaseSearch dom);
}
