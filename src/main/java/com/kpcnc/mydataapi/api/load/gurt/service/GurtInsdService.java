package com.kpcnc.mydataapi.api.load.gurt.service;

import com.kpcnc.mydataapi.api.load.gurt.models.GurtInsdSearch;
import com.kpcnc.mydataapi.api.load.gurt.models.entity.GurtInsdEntity;
import com.kpcnc.mydataapi.api.load.gurt.models.form.GurtInsdForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface GurtInsdService{
    public GurtInsdEntity regGurtInsd(GurtInsdForm dom);

    public GurtInsdEntity modGurtInsd(GurtInsdForm dom);

    public void  delGurtInsd(GurtInsdForm dom);

    public GurtInsdEntity getGurtInsd(GurtInsdSearch dom);

    public ResultListDto<GurtInsdEntity> getGurtInsdList(GurtInsdSearch dom);
}
