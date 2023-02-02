package com.abcc.mydataapi.api.base.gurt.service;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.gurt.models.GurtSearch;
import com.abcc.mydataapi.api.base.gurt.models.entity.GurtEntity;
import com.abcc.mydataapi.api.base.gurt.models.form.GurtForm;

public interface GurtService{
    public GurtEntity regGurt(GurtForm dom);

    public GurtEntity modGurt(GurtForm dom);

    public void  delGurt(GurtForm dom);

    public GurtEntity getGurt(GurtSearch dom);

    public ResultListDto<GurtEntity> getGurtList(GurtSearch dom);
}
