package com.kpcnc.mydataapi.api.load.dc.service;

import com.kpcnc.mydataapi.api.load.dc.models.DcAddSearch;
import com.kpcnc.mydataapi.api.load.dc.models.entity.DcAddEntity;
import com.kpcnc.mydataapi.api.load.dc.models.form.DcAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface DcAddService{
    public DcAddEntity regDcAdd(DcAddForm dom);

    public DcAddEntity modDcAdd(DcAddForm dom);

    public void  delDcAdd(DcAddForm dom);

    public DcAddEntity getDcAdd(DcAddSearch dom);

    public ResultListDto<DcAddEntity> getDcAddList(DcAddSearch dom);
}
