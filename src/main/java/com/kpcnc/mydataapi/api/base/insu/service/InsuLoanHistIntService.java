package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuLoanHistIntSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuLoanHistIntEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuLoanHistIntForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuLoanHistIntService{
    public InsuLoanHistIntEntity regInsuLoanHistInt(InsuLoanHistIntForm dom);

    public InsuLoanHistIntEntity modInsuLoanHistInt(InsuLoanHistIntForm dom);

    public void  delInsuLoanHistInt(InsuLoanHistIntForm dom);

    public InsuLoanHistIntEntity getInsuLoanHistInt(InsuLoanHistIntSearch dom);

    public ResultListDto<InsuLoanHistIntEntity> getInsuLoanHistIntList(InsuLoanHistIntSearch dom);
}
