package com.albee.mydataapi.api.base.ppay.service;

import com.albee.mydataapi.api.base.ppay.models.entity.PpayBalEntity;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.ppay.models.PpayBalSearch;
import com.albee.mydataapi.api.base.ppay.models.form.PpayBalForm;

public interface PpayBalService{
    public PpayBalEntity regPpayBal(PpayBalForm dom);

    public PpayBalEntity modPpayBal(PpayBalForm dom);

    public void  delPpayBal(PpayBalForm dom);

    public PpayBalEntity getPpayBal(PpayBalSearch dom);

    public ResultListDto<PpayBalEntity> getPpayBalList(PpayBalSearch dom);
}
