package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuMiSccontSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuMiSccontEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuMiSccontForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuMiSccontService{
    public InsuMiSccontEntity regInsuMiSccont(InsuMiSccontForm dom);

    public InsuMiSccontEntity modInsuMiSccont(InsuMiSccontForm dom);

    public void  delInsuMiSccont(InsuMiSccontForm dom);

    public InsuMiSccontEntity getInsuMiSccont(InsuMiSccontSearch dom);

    public ResultListDto<InsuMiSccontEntity> getInsuMiSccontList(InsuMiSccontSearch dom);
}
