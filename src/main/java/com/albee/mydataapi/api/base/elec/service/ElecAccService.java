package com.albee.mydataapi.api.base.elec.service;

import com.albee.mydataapi.api.base.elec.models.entity.ElecAccEntity;
import com.albee.mydataapi.api.base.elec.models.form.ElecAccForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.elec.models.ElecAccSearch;

public interface ElecAccService{
    public ElecAccEntity regElecAcc(ElecAccForm dom);

    public ElecAccEntity modElecAcc(ElecAccForm dom);

    public void  delElecAcc(ElecAccForm dom);

    public ElecAccEntity getElecAcc(ElecAccSearch dom);

    public ResultListDto<ElecAccEntity> getElecAccList(ElecAccSearch dom);
}
