package com.kpcnc.mydataapi.api.load.elec.service;

import com.kpcnc.mydataapi.api.load.elec.models.ElecPpayBalSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPpayBalEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPpayBalForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ElecPpayBalService{
    public ElecPpayBalEntity regElecPpayBal(ElecPpayBalForm dom);

    public ElecPpayBalEntity modElecPpayBal(ElecPpayBalForm dom);

    public void  delElecPpayBal(ElecPpayBalForm dom);

    public ElecPpayBalEntity getElecPpayBal(ElecPpayBalSearch dom);

    public ResultListDto<ElecPpayBalEntity> getElecPpayBalList(ElecPpayBalSearch dom);
}
