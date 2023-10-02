package com.albee.mydataapi.api.base.ppay.service;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayAprHistEntity;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.ppay.models.PpayAprHistSearch;
import com.albee.mydataapi.api.base.ppay.models.form.PpayAprHistForm;


public interface PpayAprHistService{
    public PpayAprHistEntity regPpayAprHist(PpayAprHistForm dom);

    public PpayAprHistEntity modPpayAprHist(PpayAprHistForm dom);

    public void  delPpayAprHist(PpayAprHistForm dom);

    public PpayAprHistEntity getPpayAprHist(PpayAprHistSearch dom);

    public PpayAprHistEntity getPpayAprHistLast(PpayAprHistSearch dom);

    public ResultListDto<PpayAprHistEntity> getPpayAprHistList(PpayAprHistSearch dom);
}
