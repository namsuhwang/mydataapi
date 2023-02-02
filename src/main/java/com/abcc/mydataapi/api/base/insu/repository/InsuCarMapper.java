package com.abcc.mydataapi.api.base.insu.repository;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuCarEntity;
import com.abcc.mydataapi.api.base.insu.models.InsuCarSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuCarMapper{
    int insertInsuCar(InsuCarEntity dom);

    int updateInsuCar(InsuCarEntity dom);

    int deleteInsuCar(InsuCarEntity dom);

    int deleteAllInsuCar(InsuCarEntity dom);

    InsuCarEntity selectInsuCar(InsuCarSearch dom);

    InsuCarEntity selectInsuCarLast(InsuCarSearch dom);

    Long selectInsuCarListTotalCnt(InsuCarSearch dom);

    List<InsuCarEntity> selectInsuCarList(InsuCarSearch dom);
}
