package com.abcc.mydataapi.api.base.insu.service;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdCarEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuInsdCarForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdCarSearch;

public interface InsuInsdCarService{
    public void regInsuInsdCar(InsuInsdCarForm dom);

    public void updInsuInsdCar(InsuInsdCarForm dom);

    public void modInsuInsdCar(InsuInsdCarForm dom);

    public void  delInsuInsdCar(InsuInsdCarForm dom);

    public void  allDelInsuInsdCar(InsuInsdCarForm dom);

    public InsuInsdCarEntity getInsuInsdCar(InsuInsdCarSearch dom);

    public InsuInsdCarEntity getInsuInsdCarLast(InsuInsdCarSearch dom);

    public ResultListDto<InsuInsdCarEntity> getInsuInsdCarList(InsuInsdCarSearch dom);
}
