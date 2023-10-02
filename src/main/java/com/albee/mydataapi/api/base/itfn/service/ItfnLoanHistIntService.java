package com.albee.mydataapi.api.base.itfn.service;

import com.albee.mydataapi.api.base.itfn.models.ItfnLoanHistIntSearch;
import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLoanHistIntEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnLoanHistIntForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface ItfnLoanHistIntService{
    public void regItfnLoanHistInt(ItfnLoanHistIntForm dom);

    public void updItfnLoanHistInt(ItfnLoanHistIntForm dom);

    public void modItfnLoanHistInt(ItfnLoanHistIntForm dom);

    public void delItfnLoanHistInt(ItfnLoanHistIntForm dom);

    public ItfnLoanHistIntEntity getItfnLoanHistInt(ItfnLoanHistIntSearch dom);

    public ResultListDto<ItfnLoanHistIntEntity> getItfnLoanHistIntList(ItfnLoanHistIntSearch dom);
}
