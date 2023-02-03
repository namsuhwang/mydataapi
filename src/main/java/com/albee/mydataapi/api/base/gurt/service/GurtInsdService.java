package com.albee.mydataapi.api.base.gurt.service;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.gurt.models.GurtInsdSearch;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtInsdEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtInsdForm;

public interface GurtInsdService{
    public void regGurtInsd(GurtInsdForm dom);

    public void updGurtInsd(GurtInsdForm dom);

    public void modGurtInsd(GurtInsdForm dom);

    public void delGurtInsd(GurtInsdForm dom);

    public void allDelGurtInsd(GurtInsdForm dom);

    public GurtInsdEntity getGurtInsd(GurtInsdSearch dom);

    public ResultListDto<GurtInsdEntity> getGurtInsdList(GurtInsdSearch dom);
}
