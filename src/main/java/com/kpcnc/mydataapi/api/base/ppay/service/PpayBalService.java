package com.kpcnc.mydataapi.api.base.ppay.service;

import com.kpcnc.mydataapi.api.base.ppay.models.PpayBalSearch;
import com.kpcnc.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import com.kpcnc.mydataapi.api.base.ppay.models.form.PpayBalForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface PpayBalService{
    public PpayBalEntity regPpayBal(PpayBalForm dom);

    public PpayBalEntity modPpayBal(PpayBalForm dom);

    public void  delPpayBal(PpayBalForm dom);

    public PpayBalEntity getPpayBal(PpayBalSearch dom);

    public ResultListDto<PpayBalEntity> getPpayBalList(PpayBalSearch dom);
}
