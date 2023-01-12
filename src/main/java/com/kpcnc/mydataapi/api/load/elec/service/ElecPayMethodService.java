package com.kpcnc.mydataapi.api.load.elec.service;


import com.kpcnc.mydataapi.api.load.elec.models.ElecPayMethodSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecPayMethodEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecPayMethodForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ElecPayMethodService{
    public ElecPayMethodEntity regElecPayMethod(ElecPayMethodForm dom);

    public ElecPayMethodEntity modElecPayMethod(ElecPayMethodForm dom);

    public void  delElecPayMethod(ElecPayMethodForm dom);

    public ElecPayMethodEntity getElecPayMethod(ElecPayMethodSearch dom);

    public ResultListDto<ElecPayMethodEntity> getElecPayMethodList(ElecPayMethodSearch dom);
}
