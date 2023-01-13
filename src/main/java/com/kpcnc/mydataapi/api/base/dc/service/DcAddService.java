package com.kpcnc.mydataapi.api.base.dc.service;

import com.kpcnc.mydataapi.api.base.dc.models.DcAddSearch;
import com.kpcnc.mydataapi.api.base.dc.models.entity.DcAddEntity;
import com.kpcnc.mydataapi.api.base.dc.models.form.DcAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface DcAddService{
    public DcAddEntity regDcAdd(DcAddForm dom);

    public DcAddEntity modDcAdd(DcAddForm dom);

    public void  delDcAdd(DcAddForm dom);

    public DcAddEntity getDcAdd(DcAddSearch dom);

    public ResultListDto<DcAddEntity> getDcAddList(DcAddSearch dom);
}
