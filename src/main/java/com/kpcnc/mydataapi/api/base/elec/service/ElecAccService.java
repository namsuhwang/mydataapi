package com.kpcnc.mydataapi.api.base.elec.service;

import com.kpcnc.mydataapi.api.base.elec.models.ElecAccSearch;
import com.kpcnc.mydataapi.api.base.elec.models.entity.ElecAccEntity;
import com.kpcnc.mydataapi.api.base.elec.models.form.ElecAccForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface ElecAccService{
    public ElecAccEntity regElecAcc(ElecAccForm dom);

    public ElecAccEntity modElecAcc(ElecAccForm dom);

    public void  delElecAcc(ElecAccForm dom);

    public ElecAccEntity getElecAcc(ElecAccSearch dom);

    public ResultListDto<ElecAccEntity> getElecAccList(ElecAccSearch dom);
}
