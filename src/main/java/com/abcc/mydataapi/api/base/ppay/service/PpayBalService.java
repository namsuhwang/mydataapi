package com.abcc.mydataapi.api.base.ppay.service;

import com.abcc.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.ppay.models.PpayBalSearch;
import com.abcc.mydataapi.api.base.ppay.models.form.PpayBalForm;

public interface PpayBalService{
    public PpayBalEntity regPpayBal(PpayBalForm dom);

    public PpayBalEntity modPpayBal(PpayBalForm dom);

    public void  delPpayBal(PpayBalForm dom);

    public PpayBalEntity getPpayBal(PpayBalSearch dom);

    public ResultListDto<PpayBalEntity> getPpayBalList(PpayBalSearch dom);
}
