package com.kpcnc.mydataapi.api.base.dc.service;

import com.kpcnc.mydataapi.api.base.dc.models.DcHistSearch;
import com.kpcnc.mydataapi.api.base.dc.models.entity.DcHistEntity;
import com.kpcnc.mydataapi.api.base.dc.models.form.DcHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface DcHistService{
    public DcHistEntity regDcHist(DcHistForm dom);

    public DcHistEntity modDcHist(DcHistForm dom);

    public void  delDcHist(DcHistForm dom);

    public DcHistEntity getDcHist(DcHistSearch dom);

    public DcHistEntity getDcHistLast(DcHistSearch dom);

    public ResultListDto<DcHistEntity> getDcHistList(DcHistSearch dom);
}
