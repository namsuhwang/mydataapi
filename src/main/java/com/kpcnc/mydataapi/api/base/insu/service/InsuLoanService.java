package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuLoanSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuLoanEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuLoanForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuLoanService{
    public void regInsuLoan(InsuLoanForm dom);

    public void updInsuLoan(InsuLoanForm dom);

    public void modInsuLoan(InsuLoanForm dom);

    public void  delInsuLoan(InsuLoanForm dom);

    public void  allDelInsuLoan(InsuLoanForm dom);

    public InsuLoanEntity getInsuLoan(InsuLoanSearch dom);

    public ResultListDto<InsuLoanEntity> getInsuLoanList(InsuLoanSearch dom);
}
