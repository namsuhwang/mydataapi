package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuCarHistSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuCarHistEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuCarHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuCarHistService{
    public InsuCarHistEntity regInsuCarHist(InsuCarHistForm dom);

    public InsuCarHistEntity modInsuCarHist(InsuCarHistForm dom);

    public void  delInsuCarHist(InsuCarHistForm dom);

    public InsuCarHistEntity getInsuCarHist(InsuCarHistSearch dom);

    public ResultListDto<InsuCarHistEntity> getInsuCarHistList(InsuCarHistSearch dom);
}
