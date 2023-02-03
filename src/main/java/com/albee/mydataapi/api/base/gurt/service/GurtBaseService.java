package com.albee.mydataapi.api.base.gurt.service;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.gurt.models.GurtBaseSearch;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtBaseEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtBaseForm;

public interface GurtBaseService{
    public void regGurtBase(GurtBaseForm dom);

    public void updGurtBase(GurtBaseForm dom);

    public void modGurtBase(GurtBaseForm dom);

    public void delGurtBase(GurtBaseForm dom);

    public GurtBaseEntity getGurtBase(GurtBaseSearch dom);

    public ResultListDto<GurtBaseEntity> getGurtBaseList(GurtBaseSearch dom);
}
