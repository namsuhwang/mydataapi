package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanAddSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanAddEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuLoanAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuLoanAddService{
    public InsuLoanAddEntity regInsuLoanAdd(InsuLoanAddForm dom);

    public InsuLoanAddEntity modInsuLoanAdd(InsuLoanAddForm dom);

    public void  delInsuLoanAdd(InsuLoanAddForm dom);

    public InsuLoanAddEntity getInsuLoanAdd(InsuLoanAddSearch dom);

    public ResultListDto<InsuLoanAddEntity> getInsuLoanAddList(InsuLoanAddSearch dom);
}
