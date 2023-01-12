package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanHistIntSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanHistIntEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuLoanHistIntForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuLoanHistIntService{
    public InsuLoanHistIntEntity regInsuLoanHistInt(InsuLoanHistIntForm dom);

    public InsuLoanHistIntEntity modInsuLoanHistInt(InsuLoanHistIntForm dom);

    public void  delInsuLoanHistInt(InsuLoanHistIntForm dom);

    public InsuLoanHistIntEntity getInsuLoanHistInt(InsuLoanHistIntSearch dom);

    public ResultListDto<InsuLoanHistIntEntity> getInsuLoanHistIntList(InsuLoanHistIntSearch dom);
}
