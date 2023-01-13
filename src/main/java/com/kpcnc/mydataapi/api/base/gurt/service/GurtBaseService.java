package com.kpcnc.mydataapi.api.base.gurt.service;

import com.kpcnc.mydataapi.api.base.gurt.models.GurtBaseSearch;
import com.kpcnc.mydataapi.api.base.gurt.models.entity.GurtBaseEntity;
import com.kpcnc.mydataapi.api.base.gurt.models.form.GurtBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface GurtBaseService{
    public GurtBaseEntity regGurtBase(GurtBaseForm dom);

    public GurtBaseEntity modGurtBase(GurtBaseForm dom);

    public void  delGurtBase(GurtBaseForm dom);

    public GurtBaseEntity getGurtBase(GurtBaseSearch dom);

    public ResultListDto<GurtBaseEntity> getGurtBaseList(GurtBaseSearch dom);
}
