package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdSccontSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdSccontEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdSccontForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuInsdSccontService{
    public InsuInsdSccontEntity regInsuInsdSccont(InsuInsdSccontForm dom);

    public InsuInsdSccontEntity modInsuInsdSccont(InsuInsdSccontForm dom);

    public void  delInsuInsdSccont(InsuInsdSccontForm dom);

    public InsuInsdSccontEntity getInsuInsdSccont(InsuInsdSccontSearch dom);

    public ResultListDto<InsuInsdSccontEntity> getInsuInsdSccontList(InsuInsdSccontSearch dom);
}
