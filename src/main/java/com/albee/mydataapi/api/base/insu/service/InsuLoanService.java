package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuLoanForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuLoanSearch;

public interface InsuLoanService{
    public void regInsuLoan(InsuLoanForm dom);

    public void updInsuLoan(InsuLoanForm dom);

    public void modInsuLoan(InsuLoanForm dom);

    public void  delInsuLoan(InsuLoanForm dom);

    public void  allDelInsuLoan(InsuLoanForm dom);

    public InsuLoanEntity getInsuLoan(InsuLoanSearch dom);

    public ResultListDto<InsuLoanEntity> getInsuLoanList(InsuLoanSearch dom);
}
