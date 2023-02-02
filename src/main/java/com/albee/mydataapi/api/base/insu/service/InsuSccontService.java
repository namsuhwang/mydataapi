package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuSccontEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuSccontForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuSccontSearch;

public interface InsuSccontService{
    public void regInsuSccont(InsuSccontForm dom);

    public void updInsuSccont(InsuSccontForm dom);

    public void modInsuSccont(InsuSccontForm dom);

    public void  delInsuSccont(InsuSccontForm dom);

    public void  allDelInsuSccont(InsuSccontForm dom);

    public InsuSccontEntity getInsuSccont(InsuSccontSearch dom);

    public InsuSccontEntity getInsuSccontLast(InsuSccontSearch dom);

    public ResultListDto<InsuSccontEntity> getInsuSccontList(InsuSccontSearch dom);
}
