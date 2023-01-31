package com.kpcnc.mydataapi.api.base.insu.repository;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdCarSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdCarEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdCarMapper{
    int insertInsuInsdCar(InsuInsdCarEntity dom);

    int updateInsuInsdCar(InsuInsdCarEntity dom);

    int deleteInsuInsdCar(InsuInsdCarEntity dom);

    int deleteAllInsuInsdCar(InsuInsdCarEntity dom);

    InsuInsdCarEntity selectInsuInsdCar(InsuInsdCarSearch dom);

    InsuInsdCarEntity selectInsuInsdCarLast(InsuInsdCarSearch dom);

    Long selectInsuInsdCarListTotalCnt(InsuInsdCarSearch dom);

    List<InsuInsdCarEntity> selectInsuInsdCarList(InsuInsdCarSearch dom);
}
