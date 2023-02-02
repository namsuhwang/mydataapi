package com.abcc.mydataapi.api.base.dc.service;

import com.abcc.mydataapi.api.base.dc.models.entity.DcHistEntity;
import com.abcc.mydataapi.api.base.dc.models.form.DcHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.dc.models.DcHistSearch;

public interface DcHistService{
    public DcHistEntity regDcHist(DcHistForm dom);

    public DcHistEntity modDcHist(DcHistForm dom);

    public void  delDcHist(DcHistForm dom);

    public DcHistEntity getDcHist(DcHistSearch dom);

    public DcHistEntity getDcHistLast(DcHistSearch dom);

    public ResultListDto<DcHistEntity> getDcHistList(DcHistSearch dom);
}
