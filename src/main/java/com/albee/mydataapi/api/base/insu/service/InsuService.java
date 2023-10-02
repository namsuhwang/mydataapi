package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuSearch;

public interface InsuService{
    public void regInsu(InsuForm dom);

    public void updInsu(InsuForm dom);

    public void modInsu(InsuForm dom);

    public void  delInsu(InsuForm dom);

    public void  allDelInsu(InsuForm dom);

    public InsuEntity getInsu(InsuSearch dom);

    public InsuEntity getInsuLast(InsuSearch dom);

    public ResultListDto<InsuEntity> getInsuList(InsuSearch dom);
}
