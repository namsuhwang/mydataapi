package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuLoanAddSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuLoanAddEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuLoanAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuLoanAddService{
    public void regInsuLoanAdd(InsuLoanAddForm dom);

    public void updInsuLoanAdd(InsuLoanAddForm dom);

    public void modInsuLoanAdd(InsuLoanAddForm dom);

    public void delInsuLoanAdd(InsuLoanAddForm dom);

    public InsuLoanAddEntity getInsuLoanAdd(InsuLoanAddSearch dom);

    public ResultListDto<InsuLoanAddEntity> getInsuLoanAddList(InsuLoanAddSearch dom);
}
