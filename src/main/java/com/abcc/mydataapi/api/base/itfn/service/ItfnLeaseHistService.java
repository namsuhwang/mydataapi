package com.abcc.mydataapi.api.base.itfn.service;

import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnLeaseHistEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnLeaseHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.itfn.models.ItfnLeaseHistSearch;

public interface ItfnLeaseHistService{
    public void regItfnLeaseHist(ItfnLeaseHistForm dom);

    public void updItfnLeaseHist(ItfnLeaseHistForm dom);

    public void modItfnLeaseHist(ItfnLeaseHistForm dom);

    public void delItfnLeaseHist(ItfnLeaseHistForm dom);

    public ItfnLeaseHistEntity getItfnLeaseHist(ItfnLeaseHistSearch dom);

    public ItfnLeaseHistEntity getItfnLeaseHistLast(ItfnLeaseHistSearch dom);

    public ResultListDto<ItfnLeaseHistEntity> getItfnLeaseHistList(ItfnLeaseHistSearch dom);
}
