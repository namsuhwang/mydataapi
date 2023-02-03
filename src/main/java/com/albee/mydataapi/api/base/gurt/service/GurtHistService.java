package com.albee.mydataapi.api.base.gurt.service;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.gurt.models.GurtHistSearch;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtHistEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtHistForm;

public interface GurtHistService{
    public void regGurtHist(GurtHistForm dom);

    public void updGurtHist(GurtHistForm dom);

    public void modGurtHist(GurtHistForm dom);

    public void delGurtHist(GurtHistForm dom);

    public GurtHistEntity getGurtHist(GurtHistSearch dom);

    public GurtHistEntity getGurtHistLast(GurtHistSearch dom);

    public ResultListDto<GurtHistEntity> getGurtHistList(GurtHistSearch dom);
}
