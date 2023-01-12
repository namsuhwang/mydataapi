package com.kpcnc.mydataapi.api.load.elec.service;

import com.kpcnc.mydataapi.api.load.elec.models.ElecAccSearch;
import com.kpcnc.mydataapi.api.load.elec.models.entity.ElecAccEntity;
import com.kpcnc.mydataapi.api.load.elec.models.form.ElecAccForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ElecAccService{
    public ElecAccEntity regElecAcc(ElecAccForm dom);

    public ElecAccEntity modElecAcc(ElecAccForm dom);

    public void  delElecAcc(ElecAccForm dom);

    public ElecAccEntity getElecAcc(ElecAccSearch dom);

    public ResultListDto<ElecAccEntity> getElecAccList(ElecAccSearch dom);
}
