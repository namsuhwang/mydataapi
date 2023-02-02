package com.albee.mydataapi.api.base.dc.service;

import com.albee.mydataapi.api.base.dc.models.entity.DcBaseEntity;
import com.albee.mydataapi.api.base.dc.models.form.DcBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.dc.models.DcBaseSearch;

public interface DcBaseService{
    public DcBaseEntity regDcBase(DcBaseForm dom);

    public DcBaseEntity modDcBase(DcBaseForm dom);

    public void  delDcBase(DcBaseForm dom);

    public DcBaseEntity getDcBase(DcBaseSearch dom);

    public ResultListDto<DcBaseEntity> getDcBaseList(DcBaseSearch dom);
}
