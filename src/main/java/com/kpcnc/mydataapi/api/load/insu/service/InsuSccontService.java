package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuSccontSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuSccontEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuSccontForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuSccontService{
    public InsuSccontEntity regInsuSccont(InsuSccontForm dom);

    public InsuSccontEntity modInsuSccont(InsuSccontForm dom);

    public void  delInsuSccont(InsuSccontForm dom);

    public InsuSccontEntity getInsuSccont(InsuSccontSearch dom);

    public ResultListDto<InsuSccontEntity> getInsuSccontList(InsuSccontSearch dom);
}
