package com.kpcnc.mydataapi.api.base.gurt.service;

import com.kpcnc.mydataapi.api.base.gurt.models.GurtSearch;
import com.kpcnc.mydataapi.api.base.gurt.models.entity.GurtEntity;
import com.kpcnc.mydataapi.api.base.gurt.models.form.GurtForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface GurtService{
    public GurtEntity regGurt(GurtForm dom);

    public GurtEntity modGurt(GurtForm dom);

    public void  delGurt(GurtForm dom);

    public GurtEntity getGurt(GurtSearch dom);

    public ResultListDto<GurtEntity> getGurtList(GurtSearch dom);
}
