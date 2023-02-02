package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuCarEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuCarForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuCarSearch;

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
