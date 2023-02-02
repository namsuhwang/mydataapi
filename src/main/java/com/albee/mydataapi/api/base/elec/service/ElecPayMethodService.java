package com.albee.mydataapi.api.base.elec.service;


import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecPayMethodSearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPayMethodEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPayMethodForm;

public interface ElecPayMethodService{
    public ElecPayMethodEntity regElecPayMethod(ElecPayMethodForm dom);

    public ElecPayMethodEntity modElecPayMethod(ElecPayMethodForm dom);

    public void  delElecPayMethod(ElecPayMethodForm dom);

    public ElecPayMethodEntity getElecPayMethod(ElecPayMethodSearch dom);

    public ResultListDto<ElecPayMethodEntity> getElecPayMethodList(ElecPayMethodSearch dom);
}
