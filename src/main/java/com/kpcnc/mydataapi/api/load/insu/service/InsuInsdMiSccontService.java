package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiSccontSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiSccontEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdMiSccontForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuInsdMiSccontService{
    public InsuInsdMiSccontEntity regInsuInsdMiSccont(InsuInsdMiSccontForm dom);

    public InsuInsdMiSccontEntity modInsuInsdMiSccont(InsuInsdMiSccontForm dom);

    public void  delInsuInsdMiSccont(InsuInsdMiSccontForm dom);

    public InsuInsdMiSccontEntity getInsuInsdMiSccont(InsuInsdMiSccontSearch dom);

    public ResultListDto<InsuInsdMiSccontEntity> getInsuInsdMiSccontList(InsuInsdMiSccontSearch dom);
}
