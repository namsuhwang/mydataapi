package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuCarSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuCarEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuCarMapper{
    int insertInsuCar(InsuCarEntity dom);

    int updateInsuCar(InsuCarEntity dom);

    int deleteInsuCar(InsuCarEntity dom);

    InsuCarEntity selectInsuCar(InsuCarSearch dom);

    Long selectInsuCarListTotalCnt(InsuCarSearch dom);

    List<InsuCarEntity> selectInsuCarList(InsuCarSearch dom);
}
