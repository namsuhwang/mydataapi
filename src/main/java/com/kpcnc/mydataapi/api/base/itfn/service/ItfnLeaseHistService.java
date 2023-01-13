package com.kpcnc.mydataapi.api.base.itfn.service;

import com.kpcnc.mydataapi.api.base.itfn.models.ItfnLeaseHistSearch;
import com.kpcnc.mydataapi.api.base.itfn.models.entity.ItfnLeaseHistEntity;
import com.kpcnc.mydataapi.api.base.itfn.models.form.ItfnLeaseHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface ItfnLeaseHistService{
    public ItfnLeaseHistEntity regItfnLeaseHist(ItfnLeaseHistForm dom);

    public ItfnLeaseHistEntity modItfnLeaseHist(ItfnLeaseHistForm dom);

    public void  delItfnLeaseHist(ItfnLeaseHistForm dom);

    public ItfnLeaseHistEntity getItfnLeaseHist(ItfnLeaseHistSearch dom);

    public ResultListDto<ItfnLeaseHistEntity> getItfnLeaseHistList(ItfnLeaseHistSearch dom);
}
