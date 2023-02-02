package com.abcc.mydataapi.api.base.dc.service;

import com.abcc.mydataapi.api.base.dc.models.entity.DcEntity;
import com.abcc.mydataapi.api.base.dc.models.form.DcForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.dc.models.DcSearch;

public interface DcService{
    public DcEntity regDc(DcForm dom);

    public DcEntity modDc(DcForm dom);

    public void  delDc(DcForm dom);

    public void  allDelDc(DcForm dom);

    public DcEntity getDc(DcSearch dom);

    public ResultListDto<DcEntity> getDcList(DcSearch dom);
}
