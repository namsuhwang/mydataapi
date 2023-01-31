package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuSccontSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuSccontEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuSccontForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

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
