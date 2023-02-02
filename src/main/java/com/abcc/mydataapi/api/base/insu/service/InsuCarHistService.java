package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuCarHistEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuCarHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuCarHistSearch;

public interface InsuCarHistService{
    public void regInsuCarHist(InsuCarHistForm dom);

    public void updInsuCarHist(InsuCarHistForm dom);

    public void modInsuCarHist(InsuCarHistForm dom);

    public void  delInsuCarHist(InsuCarHistForm dom);

    public InsuCarHistEntity getInsuCarHist(InsuCarHistSearch dom);

    public InsuCarHistEntity getInsuCarHistLast(InsuCarHistSearch dom);

    public ResultListDto<InsuCarHistEntity> getInsuCarHistList(InsuCarHistSearch dom);
}
