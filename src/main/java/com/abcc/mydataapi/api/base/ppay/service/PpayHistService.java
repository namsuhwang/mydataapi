package com.abcc.mydataapi.api.base.ppay.service;

import com.abcc.mydataapi.api.base.ppay.models.entity.PpayHistEntity;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.ppay.models.PpayHistSearch;
import com.abcc.mydataapi.api.base.ppay.models.form.PpayHistForm;

public interface PpayHistService{
    public PpayHistEntity regPpayHist(PpayHistForm dom);

    public PpayHistEntity modPpayHist(PpayHistForm dom);

    public void  delPpayHist(PpayHistForm dom);

    public PpayHistEntity getPpayHist(PpayHistSearch dom);

    public PpayHistEntity getPpayHistLast(PpayHistSearch dom);

    public ResultListDto<PpayHistEntity> getPpayHistList(PpayHistSearch dom);
}
