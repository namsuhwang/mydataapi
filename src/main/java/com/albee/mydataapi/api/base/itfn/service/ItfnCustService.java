package com.albee.mydataapi.api.base.itfn.service;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.itfn.models.ItfnCustSearch;
import com.albee.mydataapi.api.base.itfn.models.entity.ItfnCustEntity;
import com.albee.mydataapi.api.base.itfn.models.form.ItfnCustForm;

public interface ItfnCustService{
    public void regItfnCust(ItfnCustForm dom);

    public void updItfnCust(ItfnCustForm dom);

    public void modItfnCust(ItfnCustForm dom);

    public void delItfnCust(ItfnCustForm dom);

    public ItfnCustEntity getItfnCust(ItfnCustSearch dom);

    public ResultListDto<ItfnCustEntity> getItfnCustList(ItfnCustSearch dom);
}
