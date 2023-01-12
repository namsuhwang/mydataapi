package com.kpcnc.mydataapi.api.load.dc.service;

import com.kpcnc.mydataapi.api.load.dc.models.DcBaseSearch;
import com.kpcnc.mydataapi.api.load.dc.models.entity.DcBaseEntity;
import com.kpcnc.mydataapi.api.load.dc.models.form.DcBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface DcBaseService{
    public DcBaseEntity regDcBase(DcBaseForm dom);

    public DcBaseEntity modDcBase(DcBaseForm dom);

    public void  delDcBase(DcBaseForm dom);

    public DcBaseEntity getDcBase(DcBaseSearch dom);

    public ResultListDto<DcBaseEntity> getDcBaseList(DcBaseSearch dom);
}
