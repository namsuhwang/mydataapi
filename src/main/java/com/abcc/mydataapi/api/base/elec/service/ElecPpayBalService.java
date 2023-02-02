package com.abcc.mydataapi.api.base.elec.service;

import com.abcc.mydataapi.api.base.elec.models.entity.ElecPpayBalEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPpayBalForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.elec.models.ElecPpayBalSearch;

public interface ElecPpayBalService{
    public ElecPpayBalEntity regElecPpayBal(ElecPpayBalForm dom);

    public ElecPpayBalEntity modElecPpayBal(ElecPpayBalForm dom);

    public void  delElecPpayBal(ElecPpayBalForm dom);

    public ElecPpayBalEntity getElecPpayBal(ElecPpayBalSearch dom);

    public ResultListDto<ElecPpayBalEntity> getElecPpayBalList(ElecPpayBalSearch dom);
}
