package com.abcc.mydataapi.api.base.gurt.service;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.gurt.models.GurtInsdSearch;
import com.abcc.mydataapi.api.base.gurt.models.entity.GurtInsdEntity;
import com.abcc.mydataapi.api.base.gurt.models.form.GurtInsdForm;

public interface GurtInsdService{
    public GurtInsdEntity regGurtInsd(GurtInsdForm dom);

    public GurtInsdEntity modGurtInsd(GurtInsdForm dom);

    public void  delGurtInsd(GurtInsdForm dom);

    public GurtInsdEntity getGurtInsd(GurtInsdSearch dom);

    public ResultListDto<GurtInsdEntity> getGurtInsdList(GurtInsdSearch dom);
}
