package com.kpcnc.mydataapi.api.base.itfn.service;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnLoanHistIntSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLoanHistIntEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLoanHistIntForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ItfnLoanHistIntService{
    public void regItfnLoanHistInt(ItfnLoanHistIntForm dom);

    public void updItfnLoanHistInt(ItfnLoanHistIntForm dom);

    public void modItfnLoanHistInt(ItfnLoanHistIntForm dom);

    public void delItfnLoanHistInt(ItfnLoanHistIntForm dom);

    public ItfnLoanHistIntEntity getItfnLoanHistInt(ItfnLoanHistIntSearch dom);

    public ResultListDto<ItfnLoanHistIntEntity> getItfnLoanHistIntList(ItfnLoanHistIntSearch dom);
}
