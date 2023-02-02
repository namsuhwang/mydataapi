package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdSccontEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdSccontForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdSccontSearch;

public interface InsuInsdSccontService{
    public void regInsuInsdSccont(InsuInsdSccontForm dom);

    public void updInsuInsdSccont(InsuInsdSccontForm dom);

    public void modInsuInsdSccont(InsuInsdSccontForm dom);

    public void  delInsuInsdSccont(InsuInsdSccontForm dom);

    public InsuInsdSccontEntity getInsuInsdSccont(InsuInsdSccontSearch dom);

    public InsuInsdSccontEntity getInsuInsdSccontLast(InsuInsdSccontSearch dom);

    public ResultListDto<InsuInsdSccontEntity> getInsuInsdSccontList(InsuInsdSccontSearch dom);
}
