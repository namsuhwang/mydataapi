package com.albee.mydataapi.api.base.itfn.service;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLoanHistEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnLoanHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.itfn.models.ItfnLoanHistSearch;

public interface ItfnLoanHistService{
    public void regItfnLoanHist(ItfnLoanHistForm dom);

    public void updItfnLoanHist(ItfnLoanHistForm dom);

    public void modItfnLoanHist(ItfnLoanHistForm dom);

    public void delItfnLoanHist(ItfnLoanHistForm dom);

    public ItfnLoanHistEntity getItfnLoanHist(ItfnLoanHistSearch dom);

    public ItfnLoanHistEntity getItfnLoanHistLast(ItfnLoanHistSearch dom);

    public ResultListDto<ItfnLoanHistEntity> getItfnLoanHistList(ItfnLoanHistSearch dom);
}
