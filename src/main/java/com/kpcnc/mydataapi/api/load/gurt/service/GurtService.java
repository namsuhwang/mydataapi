package com.kpcnc.mydataapi.api.load.gurt.service;

import com.kpcnc.mydataapi.api.load.gurt.models.GurtSearch;
import com.kpcnc.mydataapi.api.load.gurt.models.entity.GurtEntity;
import com.kpcnc.mydataapi.api.load.gurt.models.form.GurtForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface GurtService{
    public GurtEntity regGurt(GurtForm dom);

    public GurtEntity modGurt(GurtForm dom);

    public void  delGurt(GurtForm dom);

    public GurtEntity getGurt(GurtSearch dom);

    public ResultListDto<GurtEntity> getGurtList(GurtSearch dom);
}
