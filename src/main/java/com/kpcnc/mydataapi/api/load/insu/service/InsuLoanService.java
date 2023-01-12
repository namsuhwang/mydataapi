package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuLoanForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuLoanService{
    public InsuLoanEntity regInsuLoan(InsuLoanForm dom);

    public InsuLoanEntity modInsuLoan(InsuLoanForm dom);

    public void  delInsuLoan(InsuLoanForm dom);

    public InsuLoanEntity getInsuLoan(InsuLoanSearch dom);

    public ResultListDto<InsuLoanEntity> getInsuLoanList(InsuLoanSearch dom);
}
