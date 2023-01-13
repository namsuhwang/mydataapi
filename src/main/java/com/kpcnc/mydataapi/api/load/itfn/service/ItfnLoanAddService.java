package com.kpcnc.mydataapi.api.load.itfn.service;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLoanAddSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanAddEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLoanAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ItfnLoanAddService{
    public ItfnLoanAddEntity regItfnLoanAdd(ItfnLoanAddForm dom);

    public ItfnLoanAddEntity modItfnLoanAdd(ItfnLoanAddForm dom);

    public void  delItfnLoanAdd(ItfnLoanAddForm dom);

    public ItfnLoanAddEntity getItfnLoanAdd(ItfnLoanAddSearch dom);

    public ResultListDto<ItfnLoanAddEntity> getItfnLoanAddList(ItfnLoanAddSearch dom);
}
