package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdMiSccontEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdMiSccontForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdMiSccontSearch;

public interface InsuInsdMiSccontService{
    public void regInsuInsdMiSccont(InsuInsdMiSccontForm dom);

    public void updInsuInsdMiSccont(InsuInsdMiSccontForm dom);

    public void modInsuInsdMiSccont(InsuInsdMiSccontForm dom);

    public void  delInsuInsdMiSccont(InsuInsdMiSccontForm dom);

    public void  allDelInsuInsdMiSccont(InsuInsdMiSccontForm dom);

    public InsuInsdMiSccontEntity getInsuInsdMiSccont(InsuInsdMiSccontSearch dom);

    public InsuInsdMiSccontEntity getInsuInsdMiSccontLast(InsuInsdMiSccontSearch dom);

    public ResultListDto<InsuInsdMiSccontEntity> getInsuInsdMiSccontList(InsuInsdMiSccontSearch dom);
}
