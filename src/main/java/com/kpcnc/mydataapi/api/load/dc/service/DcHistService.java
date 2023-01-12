package com.kpcnc.mydataapi.api.load.dc.service;

import com.kpcnc.mydataapi.api.load.dc.models.DcHistSearch;
import com.kpcnc.mydataapi.api.load.dc.models.entity.DcHistEntity;
import com.kpcnc.mydataapi.api.load.dc.models.form.DcHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface DcHistService{
    public DcHistEntity regDcHist(DcHistForm dom);

    public DcHistEntity modDcHist(DcHistForm dom);

    public void  delDcHist(DcHistForm dom);

    public DcHistEntity getDcHist(DcHistSearch dom);

    public ResultListDto<DcHistEntity> getDcHistList(DcHistSearch dom);
}
