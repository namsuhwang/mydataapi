package com.albee.mydataapi.api.base.gurt.service;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.gurt.models.GurtSearch;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtForm;

public interface GurtService{
    public void regGurt(GurtForm dom);

    public void updGurt(GurtForm dom);

    public void modGurt(GurtForm dom);

    public void delGurt(GurtForm dom);

    public void allDelGurt(GurtForm dom);

    public GurtEntity getGurt(GurtSearch dom);

    public GurtEntity getGurtLast(GurtSearch dom);

    public ResultListDto<GurtEntity> getGurtList(GurtSearch dom);
}
