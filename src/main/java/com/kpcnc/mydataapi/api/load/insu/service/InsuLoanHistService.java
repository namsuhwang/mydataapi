package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuLoanHistSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuLoanHistEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuLoanHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuLoanHistService{
    public InsuLoanHistEntity regInsuLoanHist(InsuLoanHistForm dom);

    public InsuLoanHistEntity modInsuLoanHist(InsuLoanHistForm dom);

    public void  delInsuLoanHist(InsuLoanHistForm dom);

    public InsuLoanHistEntity getInsuLoanHist(InsuLoanHistSearch dom);

    public ResultListDto<InsuLoanHistEntity> getInsuLoanHistList(InsuLoanHistSearch dom);
}
