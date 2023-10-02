package com.albee.mydataapi.api.base.itfn.service;

import com.albee.mydataapi.api.base.itfn.models.entity.ItfnLeaseEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnLeaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.itfn.models.ItfnLeaseSearch;

public interface ItfnLeaseService{
    public void regItfnLease(ItfnLeaseForm dom);

    public void updItfnLease(ItfnLeaseForm dom);

    public void modItfnLease(ItfnLeaseForm dom);

    public void delItfnLease(ItfnLeaseForm dom);

    public ItfnLeaseEntity getItfnLease(ItfnLeaseSearch dom);

    public ResultListDto<ItfnLeaseEntity> getItfnLeaseList(ItfnLeaseSearch dom);
}
