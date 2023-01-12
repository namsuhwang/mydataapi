package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanBaseEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuLoanBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuLoanBaseService{
    public InsuLoanBaseEntity regInsuLoanBase(InsuLoanBaseForm dom);

    public InsuLoanBaseEntity modInsuLoanBase(InsuLoanBaseForm dom);

    public void  delInsuLoanBase(InsuLoanBaseForm dom);

    public InsuLoanBaseEntity getInsuLoanBase(InsuLoanBaseSearch dom);

    public ResultListDto<InsuLoanBaseEntity> getInsuLoanBaseList(InsuLoanBaseSearch dom);
}
