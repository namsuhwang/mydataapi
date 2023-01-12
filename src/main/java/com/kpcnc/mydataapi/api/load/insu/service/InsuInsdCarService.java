package com.kpcnc.mydataapi.api.load.insu.service;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdCarSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdCarEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuInsdCarForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InsuInsdCarService{
    public InsuInsdCarEntity regInsuInsdCar(InsuInsdCarForm dom);

    public InsuInsdCarEntity modInsuInsdCar(InsuInsdCarForm dom);

    public void  delInsuInsdCar(InsuInsdCarForm dom);

    public InsuInsdCarEntity getInsuInsdCar(InsuInsdCarSearch dom);

    public ResultListDto<InsuInsdCarEntity> getInsuInsdCarList(InsuInsdCarSearch dom);
}
