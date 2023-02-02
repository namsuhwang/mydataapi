package com.albee.mydataapi.api.base.gurt.service;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.gurt.models.GurtInsdSearch;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtInsdEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtInsdForm;

public interface GurtInsdService{
    public GurtInsdEntity regGurtInsd(GurtInsdForm dom);

    public GurtInsdEntity modGurtInsd(GurtInsdForm dom);

    public void  delGurtInsd(GurtInsdForm dom);

    public GurtInsdEntity getGurtInsd(GurtInsdSearch dom);

    public ResultListDto<GurtInsdEntity> getGurtInsdList(GurtInsdSearch dom);
}
