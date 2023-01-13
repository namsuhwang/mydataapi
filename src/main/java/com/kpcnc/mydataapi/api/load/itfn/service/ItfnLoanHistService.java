package com.kpcnc.mydataapi.api.load.itfn.service;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLoanHistSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLoanHistEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLoanHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ItfnLoanHistService{
    public ItfnLoanHistEntity regItfnLoanHist(ItfnLoanHistForm dom);

    public ItfnLoanHistEntity modItfnLoanHist(ItfnLoanHistForm dom);

    public void  delItfnLoanHist(ItfnLoanHistForm dom);

    public ItfnLoanHistEntity getItfnLoanHist(ItfnLoanHistSearch dom);

    public ResultListDto<ItfnLoanHistEntity> getItfnLoanHistList(ItfnLoanHistSearch dom);
}
