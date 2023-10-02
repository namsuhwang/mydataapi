package com.albee.mydataapi.api.base.elec.service;

import com.albee.mydataapi.api.base.elec.models.entity.ElecPpayBalEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPpayBalForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPpayBalSearch;

public interface ElecPpayBalService{
    public void regElecPpayBal(ElecPpayBalForm dom);

    public void updElecPpayBal(ElecPpayBalForm dom);

    public void modElecPpayBal(ElecPpayBalForm dom);

    public void delElecPpayBal(ElecPpayBalForm dom);

    public ElecPpayBalEntity getElecPpayBal(ElecPpayBalSearch dom);

    public ResultListDto<ElecPpayBalEntity> getElecPpayBalList(ElecPpayBalSearch dom);
}
