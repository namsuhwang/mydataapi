package com.kpcnc.mydataapi.api.base.itfn.service;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnLoanHistSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLoanHistEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLoanHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface ItfnLoanHistService{
    public void regItfnLoanHist(ItfnLoanHistForm dom);

    public void updItfnLoanHist(ItfnLoanHistForm dom);

    public void modItfnLoanHist(ItfnLoanHistForm dom);

    public void delItfnLoanHist(ItfnLoanHistForm dom);

    public ItfnLoanHistEntity getItfnLoanHist(ItfnLoanHistSearch dom);

    public ItfnLoanHistEntity getItfnLoanHistLast(ItfnLoanHistSearch dom);

    public ResultListDto<ItfnLoanHistEntity> getItfnLoanHistList(ItfnLoanHistSearch dom);
}
