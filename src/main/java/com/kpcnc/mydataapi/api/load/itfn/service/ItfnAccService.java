package com.kpcnc.mydataapi.api.load.itfn.service;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnAccSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnAccEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnAccForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ItfnAccService{
    public ItfnAccEntity regItfnAcc(ItfnAccForm dom);

    public ItfnAccEntity modItfnAcc(ItfnAccForm dom);

    public void  delItfnAcc(ItfnAccForm dom);

    public ItfnAccEntity getItfnAcc(ItfnAccSearch dom);

    public ResultListDto<ItfnAccEntity> getItfnAccList(ItfnAccSearch dom);
}
