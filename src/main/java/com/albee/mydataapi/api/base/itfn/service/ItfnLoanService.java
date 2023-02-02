package com.albee.mydataapi.api.base.itfn.service;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLoanEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnLoanForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.itfn.models.ItfnLoanSearch;

public interface ItfnLoanService{
    public void regItfnLoan(ItfnLoanForm dom);

    public void updItfnLoan(ItfnLoanForm dom);

    public void modItfnLoan(ItfnLoanForm dom);

    public void delItfnLoan(ItfnLoanForm dom);

    public ItfnLoanEntity getItfnLoan(ItfnLoanSearch dom);

    public ResultListDto<ItfnLoanEntity> getItfnLoanList(ItfnLoanSearch dom);
}
