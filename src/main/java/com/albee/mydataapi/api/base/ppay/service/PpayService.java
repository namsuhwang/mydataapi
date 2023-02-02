package com.albee.mydataapi.api.base.ppay.service;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayEntity;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.ppay.models.PpaySearch;
import com.albee.mydataapi.api.base.ppay.models.form.PpayForm;

public interface PpayService{
    public PpayEntity regPpay(PpayForm dom);

    public PpayEntity modPpay(PpayForm dom);

    public void  delPpay(PpayForm dom);

    public void  allDelPpay(PpayForm dom);

    public PpayEntity getPpay(PpaySearch dom);

    public ResultListDto<PpayEntity> getPpayList(PpaySearch dom);
}
