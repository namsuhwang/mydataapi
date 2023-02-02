package com.albee.mydataapi.api.base.insu.service;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdSccontEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdSccontForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdSccontSearch;

public interface InsuInsdSccontService{
    public void regInsuInsdSccont(InsuInsdSccontForm dom);

    public void updInsuInsdSccont(InsuInsdSccontForm dom);

    public void modInsuInsdSccont(InsuInsdSccontForm dom);

    public void  delInsuInsdSccont(InsuInsdSccontForm dom);

    public InsuInsdSccontEntity getInsuInsdSccont(InsuInsdSccontSearch dom);

    public InsuInsdSccontEntity getInsuInsdSccontLast(InsuInsdSccontSearch dom);

    public ResultListDto<InsuInsdSccontEntity> getInsuInsdSccontList(InsuInsdSccontSearch dom);
}
