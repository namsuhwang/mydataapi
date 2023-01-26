package com.kpcnc.mydataapi.api.base.dc.service;

import com.kpcnc.mydataapi.api.base.dc.models.DcSearch;
import com.kpcnc.mydataapi.api.base.dc.models.entity.DcEntity;
import com.kpcnc.mydataapi.api.base.dc.models.form.DcForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface DcService{
    public DcEntity regDc(DcForm dom);

    public DcEntity modDc(DcForm dom);

    public void  delDc(DcForm dom);

    public void  allDelDc(DcForm dom);

    public DcEntity getDc(DcSearch dom);

    public ResultListDto<DcEntity> getDcList(DcSearch dom);
}
