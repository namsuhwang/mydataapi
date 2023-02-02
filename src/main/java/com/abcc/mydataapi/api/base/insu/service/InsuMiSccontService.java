package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuMiSccontEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuMiSccontForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuMiSccontSearch;

public interface InsuMiSccontService{
    public void regInsuMiSccont(InsuMiSccontForm dom);

    public void updInsuMiSccont(InsuMiSccontForm dom);

    public void modInsuMiSccont(InsuMiSccontForm dom);

    public void delInsuMiSccont(InsuMiSccontForm dom);

    public void allDelInsuMiSccont(InsuMiSccontForm dom);

    public InsuMiSccontEntity getInsuMiSccont(InsuMiSccontSearch dom);

    public InsuMiSccontEntity getInsuMiSccontLast(InsuMiSccontSearch dom);

    public ResultListDto<InsuMiSccontEntity> getInsuMiSccontList(InsuMiSccontSearch dom);
}
