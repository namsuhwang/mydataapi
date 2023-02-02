package com.albee.mydataapi.api.base.gurt.service;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.gurt.models.GurtSearch;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtForm;

public interface GurtService{
    public GurtEntity regGurt(GurtForm dom);

    public GurtEntity modGurt(GurtForm dom);

    public void  delGurt(GurtForm dom);

    public GurtEntity getGurt(GurtSearch dom);

    public ResultListDto<GurtEntity> getGurtList(GurtSearch dom);
}
