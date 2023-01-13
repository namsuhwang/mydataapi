package com.kpcnc.mydataapi.api.base.itfn.service;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnAccSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnAccEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnAccForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface ItfnAccService{
    public ItfnAccEntity regItfnAcc(ItfnAccForm dom);

    public ItfnAccEntity modItfnAcc(ItfnAccForm dom);

    public void  delItfnAcc(ItfnAccForm dom);

    public ItfnAccEntity getItfnAcc(ItfnAccSearch dom);

    public ResultListDto<ItfnAccEntity> getItfnAccList(ItfnAccSearch dom);
}
