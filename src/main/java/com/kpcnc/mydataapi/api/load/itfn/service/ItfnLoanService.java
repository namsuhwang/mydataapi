package com.kpcnc.mydataapi.api.load.itfn.service;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLoanSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLoanForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ItfnLoanService{
    public ItfnLoanEntity regItfnLoan(ItfnLoanForm dom);

    public ItfnLoanEntity modItfnLoan(ItfnLoanForm dom);

    public void  delItfnLoan(ItfnLoanForm dom);

    public ItfnLoanEntity getItfnLoan(ItfnLoanSearch dom);

    public ResultListDto<ItfnLoanEntity> getItfnLoanList(ItfnLoanSearch dom);
}
