package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuCarSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuCarEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuCarForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuCarService{
    public InsuCarEntity regInsuCar(InsuCarForm dom);

    public InsuCarEntity modInsuCar(InsuCarForm dom);

    public void  delInsuCar(InsuCarForm dom);

    public InsuCarEntity getInsuCar(InsuCarSearch dom);

    public ResultListDto<InsuCarEntity> getInsuCarList(InsuCarSearch dom);
}
