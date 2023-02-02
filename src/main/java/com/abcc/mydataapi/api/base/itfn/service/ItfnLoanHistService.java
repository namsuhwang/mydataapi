package com.abcc.mydataapi.api.base.itfn.service;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLoanHistEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnLoanHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.itfn.models.ItfnLoanHistSearch;

public interface ItfnLoanHistService{
    public void regItfnLoanHist(ItfnLoanHistForm dom);

    public void updItfnLoanHist(ItfnLoanHistForm dom);

    public void modItfnLoanHist(ItfnLoanHistForm dom);

    public void delItfnLoanHist(ItfnLoanHistForm dom);

    public ItfnLoanHistEntity getItfnLoanHist(ItfnLoanHistSearch dom);

    public ItfnLoanHistEntity getItfnLoanHistLast(ItfnLoanHistSearch dom);

    public ResultListDto<ItfnLoanHistEntity> getItfnLoanHistList(ItfnLoanHistSearch dom);
}
