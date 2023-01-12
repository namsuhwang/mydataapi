package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuCarHistSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuCarHistEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuCarHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuCarHistService{
    public InsuCarHistEntity regInsuCarHist(InsuCarHistForm dom);

    public InsuCarHistEntity modInsuCarHist(InsuCarHistForm dom);

    public void  delInsuCarHist(InsuCarHistForm dom);

    public InsuCarHistEntity getInsuCarHist(InsuCarHistSearch dom);

    public ResultListDto<InsuCarHistEntity> getInsuCarHistList(InsuCarHistSearch dom);
}
