package com.albee.mydataapi.api.base.dc.service;

import com.albee.mydataapi.api.base.dc.models.entity.DcAddEntity;
import com.albee.mydataapi.api.base.dc.models.form.DcAddForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.dc.models.DcAddSearch;

public interface DcAddService{
    public void regDcAdd(DcAddForm dom);

    public void updDcAdd(DcAddForm dom);

    public void modDcAdd(DcAddForm dom);

    public void  delDcAdd(DcAddForm dom);

    public DcAddEntity getDcAdd(DcAddSearch dom);

    public DcAddEntity getDcAddLast(DcAddSearch dom);

    public ResultListDto<DcAddEntity> getDcAddList(DcAddSearch dom);
}
