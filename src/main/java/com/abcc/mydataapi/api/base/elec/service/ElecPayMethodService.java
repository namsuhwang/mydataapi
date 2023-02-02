package com.abcc.mydataapi.api.base.elec.service;


import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.elec.models.ElecPayMethodSearch;
import com.abcc.mydataapi.api.base.elec.models.entity.ElecPayMethodEntity;
import com.abcc.mydataapi.api.base.elec.models.form.ElecPayMethodForm;

public interface ElecPayMethodService{
    public ElecPayMethodEntity regElecPayMethod(ElecPayMethodForm dom);

    public ElecPayMethodEntity modElecPayMethod(ElecPayMethodForm dom);

    public void  delElecPayMethod(ElecPayMethodForm dom);

    public ElecPayMethodEntity getElecPayMethod(ElecPayMethodSearch dom);

    public ResultListDto<ElecPayMethodEntity> getElecPayMethodList(ElecPayMethodSearch dom);
}
