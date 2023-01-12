package com.kpcnc.mydataapi.api.load.dc.service;

import com.kpcnc.mydataapi.api.load.dc.models.DcSearch;
import com.kpcnc.mydataapi.api.load.dc.models.entity.DcEntity;
import com.kpcnc.mydataapi.api.load.dc.models.form.DcForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface DcService{
    public DcEntity regDc(DcForm dom);

    public DcEntity modDc(DcForm dom);

    public void  delDc(DcForm dom);

    public DcEntity getDc(DcSearch dom);

    public ResultListDto<DcEntity> getDcList(DcSearch dom);
}
