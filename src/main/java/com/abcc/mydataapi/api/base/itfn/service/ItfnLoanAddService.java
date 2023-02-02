package com.abcc.mydataapi.api.base.itfn.service;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLoanAddEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnLoanAddForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.itfn.models.ItfnLoanAddSearch;

public interface ItfnLoanAddService{
    public void regItfnLoanAdd(ItfnLoanAddForm dom);

    public void updItfnLoanAdd(ItfnLoanAddForm dom);

    public void modItfnLoanAdd(ItfnLoanAddForm dom);

    public void delItfnLoanAdd(ItfnLoanAddForm dom);

    public ItfnLoanAddEntity getItfnLoanAdd(ItfnLoanAddSearch dom);

    public ResultListDto<ItfnLoanAddEntity> getItfnLoanAddList(ItfnLoanAddSearch dom);
}
