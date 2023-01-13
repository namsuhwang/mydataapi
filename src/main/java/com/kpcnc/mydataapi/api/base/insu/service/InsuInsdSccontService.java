package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdSccontSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdSccontEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuInsdSccontForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuInsdSccontService{
    public InsuInsdSccontEntity regInsuInsdSccont(InsuInsdSccontForm dom);

    public InsuInsdSccontEntity modInsuInsdSccont(InsuInsdSccontForm dom);

    public void  delInsuInsdSccont(InsuInsdSccontForm dom);

    public InsuInsdSccontEntity getInsuInsdSccont(InsuInsdSccontSearch dom);

    public ResultListDto<InsuInsdSccontEntity> getInsuInsdSccontList(InsuInsdSccontSearch dom);
}
