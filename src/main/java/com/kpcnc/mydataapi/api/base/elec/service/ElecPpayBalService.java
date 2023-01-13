package com.kpcnc.mydataapi.api.base.elec.service;

import com.kpcnc.mydataapi.api.base.elec.models.ElecPpayBalSearch;
import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecPpayBalEntity;
import com.kpcnc.mydataapi.api.base.elec.models.form.ElecPpayBalForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface ElecPpayBalService{
    public ElecPpayBalEntity regElecPpayBal(ElecPpayBalForm dom);

    public ElecPpayBalEntity modElecPpayBal(ElecPpayBalForm dom);

    public void  delElecPpayBal(ElecPpayBalForm dom);

    public ElecPpayBalEntity getElecPpayBal(ElecPpayBalSearch dom);

    public ResultListDto<ElecPpayBalEntity> getElecPpayBalList(ElecPpayBalSearch dom);
}
