package com.kpcnc.mydataapi.api.load.itfn.service;

import com.kpcnc.mydataapi.api.load.itfn.models.ItfnLeaseSearch;
import com.kpcnc.mydataapi.api.load.itfn.models.entity.ItfnLeaseEntity;
import com.kpcnc.mydataapi.api.load.itfn.models.form.ItfnLeaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface ItfnLeaseService{
    public ItfnLeaseEntity regItfnLease(ItfnLeaseForm dom);

    public ItfnLeaseEntity modItfnLease(ItfnLeaseForm dom);

    public void  delItfnLease(ItfnLeaseForm dom);

    public ItfnLeaseEntity getItfnLease(ItfnLeaseSearch dom);

    public ResultListDto<ItfnLeaseEntity> getItfnLeaseList(ItfnLeaseSearch dom);
}
