package com.kpcnc.mydataapi.api.base.ppay.service;

import com.kpcnc.mydataapi.api.base.ppay.models.PpaySearch;
import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayEntity;
import com.kpcnc.mydataapi.api.base.ppay.models.form.PpayForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface PpayService{
    public PpayEntity regPpay(PpayForm dom);

    public PpayEntity modPpay(PpayForm dom);

    public void  delPpay(PpayForm dom);

    public void  allDelPpay(PpayForm dom);

    public PpayEntity getPpay(PpaySearch dom);

    public ResultListDto<PpayEntity> getPpayList(PpaySearch dom);
}
