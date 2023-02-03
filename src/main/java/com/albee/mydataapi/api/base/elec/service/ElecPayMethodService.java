package com.albee.mydataapi.api.base.elec.service;


import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPayMethodSearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPayMethodEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPayMethodForm;

public interface ElecPayMethodService{
    public void regElecPayMethod(ElecPayMethodForm dom);

    public void updElecPayMethod(ElecPayMethodForm dom);

    public void modElecPayMethod(ElecPayMethodForm dom);

    public void delElecPayMethod(ElecPayMethodForm dom);

    public void allDelElecPayMethod(ElecPayMethodForm dom);

    public ElecPayMethodEntity getElecPayMethod(ElecPayMethodSearch dom);

    public ElecPayMethodEntity getElecPayMethodLast(ElecPayMethodSearch dom);

    public ResultListDto<ElecPayMethodEntity> getElecPayMethodList(ElecPayMethodSearch dom);
}
