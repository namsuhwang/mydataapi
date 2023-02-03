package com.albee.mydataapi.api.base.elec.service;

import com.albee.mydataapi.api.base.elec.models.ElecPayHistSearch;
import com.albee.mydataapi.api.base.elec.models.entity.ElecPayHistEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecPayHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ElecPayHistService{
    public void regElecPayHist(ElecPayHistForm dom);

    public void updElecPayHist(ElecPayHistForm dom);

    public void modElecPayHist(ElecPayHistForm dom);

    public void delElecPayHist(ElecPayHistForm dom);

    public ElecPayHistEntity getElecPayHist(ElecPayHistSearch dom);

    public ElecPayHistEntity getElecPayHistLast(ElecPayHistSearch dom);

    public ResultListDto<ElecPayHistEntity> getElecPayHistList(ElecPayHistSearch dom);
}
