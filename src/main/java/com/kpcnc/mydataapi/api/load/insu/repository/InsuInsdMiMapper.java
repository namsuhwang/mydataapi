package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdMiMapper{
    int insertInsuInsdMi(InsuInsdMiEntity dom);

    int updateInsuInsdMi(InsuInsdMiEntity dom);

    int deleteInsuInsdMi(InsuInsdMiEntity dom);

    InsuInsdMiEntity selectInsuInsdMi(InsuInsdMiSearch dom);

    Long selectInsuInsdMiListTotalCnt(InsuInsdMiSearch dom);

    List<InsuInsdMiEntity> selectInsuInsdMiList(InsuInsdMiSearch dom);
}
