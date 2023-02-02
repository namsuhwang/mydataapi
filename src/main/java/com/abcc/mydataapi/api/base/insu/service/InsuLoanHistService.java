package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuLoanHistEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuLoanHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuLoanHistSearch;

public interface InsuLoanHistService{
    public void regInsuLoanHist(InsuLoanHistForm dom);

    public void updInsuLoanHist(InsuLoanHistForm dom);

    public void modInsuLoanHist(InsuLoanHistForm dom);

    public void  delInsuLoanHist(InsuLoanHistForm dom);

    public InsuLoanHistEntity getInsuLoanHist(InsuLoanHistSearch dom);

    public InsuLoanHistEntity getInsuLoanHistLast(InsuLoanHistSearch dom);

    public ResultListDto<InsuLoanHistEntity> getInsuLoanHistList(InsuLoanHistSearch dom);
}
