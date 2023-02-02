package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuLoanHistIntEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuLoanHistIntForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuLoanHistIntSearch;

public interface InsuLoanHistIntService{
    public void regInsuLoanHistInt(InsuLoanHistIntForm dom);

    public void updInsuLoanHistInt(InsuLoanHistIntForm dom);

    public void modInsuLoanHistInt(InsuLoanHistIntForm dom);

    public void  delInsuLoanHistInt(InsuLoanHistIntForm dom);

    public InsuLoanHistIntEntity getInsuLoanHistInt(InsuLoanHistIntSearch dom);

    public ResultListDto<InsuLoanHistIntEntity> getInsuLoanHistIntList(InsuLoanHistIntSearch dom);
}
