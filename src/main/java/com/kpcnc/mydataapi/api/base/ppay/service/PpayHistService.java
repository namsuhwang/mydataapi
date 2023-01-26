package com.kpcnc.mydataapi.api.base.ppay.service;

import com.kpcnc.mydataapi.api.base.ppay.models.PpayHistSearch;
import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayHistEntity;
import com.kpcnc.mydataapi.api.base.ppay.models.form.PpayHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface PpayHistService{
    public PpayHistEntity regPpayHist(PpayHistForm dom);

    public PpayHistEntity modPpayHist(PpayHistForm dom);

    public void  delPpayHist(PpayHistForm dom);

    public PpayHistEntity getPpayHist(PpayHistSearch dom);

    public PpayHistEntity getPpayHistLast(PpayHistSearch dom);

    public ResultListDto<PpayHistEntity> getPpayHistList(PpayHistSearch dom);
}
