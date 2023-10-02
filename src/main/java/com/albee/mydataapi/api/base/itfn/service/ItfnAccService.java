package com.albee.mydataapi.api.base.itfn.service;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnAccEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnAccForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.itfn.models.ItfnAccSearch;

public interface ItfnAccService{
    public void regItfnAcc(ItfnAccForm dom);

    public void updItfnAcc(ItfnAccForm dom);

    public void modItfnAcc(ItfnAccForm dom);

    public void delItfnAcc(ItfnAccForm dom);

    public void allDelItfnAcc(ItfnAccForm dom);

    public ItfnAccEntity getItfnAcc(ItfnAccSearch dom);

    public ResultListDto<ItfnAccEntity> getItfnAccList(ItfnAccSearch dom);
}
