package com.kpcnc.mydataapi.api.load.gurt.service;

import com.kpcnc.mydataapi.api.load.gurt.models.GurtHistSearch;
import com.kpcnc.mydataapi.api.load.gurt.models.entity.GurtHistEntity;
import com.kpcnc.mydataapi.api.load.gurt.models.form.GurtHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface GurtHistService{
    public GurtHistEntity regGurtHist(GurtHistForm dom);

    public GurtHistEntity modGurtHist(GurtHistForm dom);

    public void  delGurtHist(GurtHistForm dom);

    public GurtHistEntity getGurtHist(GurtHistSearch dom);

    public ResultListDto<GurtHistEntity> getGurtHistList(GurtHistSearch dom);
}
