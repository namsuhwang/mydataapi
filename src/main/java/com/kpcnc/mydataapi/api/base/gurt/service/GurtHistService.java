package com.kpcnc.mydataapi.api.base.gurt.service;

import com.kpcnc.mydataapi.api.base.gurt.models.GurtHistSearch;
import com.kpcnc.mydataapi.api.base.gurt.models.entity.GurtHistEntity;
import com.kpcnc.mydataapi.api.base.gurt.models.form.GurtHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface GurtHistService{
    public GurtHistEntity regGurtHist(GurtHistForm dom);

    public GurtHistEntity modGurtHist(GurtHistForm dom);

    public void  delGurtHist(GurtHistForm dom);

    public GurtHistEntity getGurtHist(GurtHistSearch dom);

    public ResultListDto<GurtHistEntity> getGurtHistList(GurtHistSearch dom);
}
