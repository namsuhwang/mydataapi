package com.abcc.mydataapi.api.base.gurt.service;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.gurt.models.GurtBaseSearch;
import com.abcc.mydataapi.api.base.gurt.models.entity.GurtBaseEntity;
import com.abcc.mydataapi.api.base.gurt.models.form.GurtBaseForm;

public interface GurtBaseService{
    public GurtBaseEntity regGurtBase(GurtBaseForm dom);

    public GurtBaseEntity modGurtBase(GurtBaseForm dom);

    public void  delGurtBase(GurtBaseForm dom);

    public GurtBaseEntity getGurtBase(GurtBaseSearch dom);

    public ResultListDto<GurtBaseEntity> getGurtBaseList(GurtBaseSearch dom);
}
