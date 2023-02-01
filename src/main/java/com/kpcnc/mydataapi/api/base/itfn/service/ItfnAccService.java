package com.kpcnc.mydataapi.api.base.itfn.service;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnAccSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnAccEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnAccForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface ItfnAccService{
    public void regItfnAcc(ItfnAccForm dom);

    public void updItfnAcc(ItfnAccForm dom);

    public void modItfnAcc(ItfnAccForm dom);

    public void delItfnAcc(ItfnAccForm dom);

    public void allDelItfnAcc(ItfnAccForm dom);

    public ItfnAccEntity getItfnAcc(ItfnAccSearch dom);

    public ResultListDto<ItfnAccEntity> getItfnAccList(ItfnAccSearch dom);
}
