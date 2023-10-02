package com.albee.mydataapi.api.base.ppay.service;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayHistEntity;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.ppay.models.PpayHistSearch;
import com.albee.mydataapi.api.base.ppay.models.form.PpayHistForm;

public interface PpayHistService{
    public PpayHistEntity regPpayHist(PpayHistForm dom);

    public PpayHistEntity modPpayHist(PpayHistForm dom);

    public void  delPpayHist(PpayHistForm dom);

    public PpayHistEntity getPpayHist(PpayHistSearch dom);

    public PpayHistEntity getPpayHistLast(PpayHistSearch dom);

    public ResultListDto<PpayHistEntity> getPpayHistList(PpayHistSearch dom);
}
