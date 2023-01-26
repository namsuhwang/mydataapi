package com.kpcnc.mydataapi.api.base.ppay.service;

import com.kpcnc.mydataapi.api.base.ppay.models.PpayAprHistSearch;
import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayAprHistEntity;
import com.kpcnc.mydataapi.api.base.ppay.models.form.PpayAprHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;


public interface PpayAprHistService{
    public PpayAprHistEntity regPpayAprHist(PpayAprHistForm dom);

    public PpayAprHistEntity modPpayAprHist(PpayAprHistForm dom);

    public void  delPpayAprHist(PpayAprHistForm dom);

    public PpayAprHistEntity getPpayAprHist(PpayAprHistSearch dom);

    public PpayAprHistEntity getPpayAprHistLast(PpayAprHistSearch dom);

    public ResultListDto<PpayAprHistEntity> getPpayAprHistList(PpayAprHistSearch dom);
}
