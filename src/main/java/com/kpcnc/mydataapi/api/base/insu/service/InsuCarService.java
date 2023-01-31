package com.kpcnc.mydataapi.api.base.insu.service;

import com.kpcnc.mydataapi.api.base.insu.models.InsuCarSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuCarEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuCarForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InsuCarService{
    public void regInsuCar(InsuCarForm dom);

    public void updInsuCar(InsuCarForm dom);

    public void modInsuCar(InsuCarForm dom);

    public void  delInsuCar(InsuCarForm dom);

    public void  allDelInsuCar(InsuCarForm dom);

    public InsuCarEntity getInsuCar(InsuCarSearch dom);

    public InsuCarEntity getInsuCarLast(InsuCarSearch dom);

    public ResultListDto<InsuCarEntity> getInsuCarList(InsuCarSearch dom);
}
