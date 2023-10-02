package com.albee.mydataapi.api.base.insu.repository;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdMiEntity;
import com.albee.mydataapi.api.base.insu.models.InsuInsdMiSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdMiMapper{
    int insertInsuInsdMi(InsuInsdMiEntity dom);

    int updateInsuInsdMi(InsuInsdMiEntity dom);

    int deleteInsuInsdMi(InsuInsdMiEntity dom);

    int deleteAllInsuInsdMi(InsuInsdMiEntity dom);

    InsuInsdMiEntity selectInsuInsdMi(InsuInsdMiSearch dom);

    InsuInsdMiEntity selectInsuInsdMiLast(InsuInsdMiSearch dom);

    Long selectInsuInsdMiListTotalCnt(InsuInsdMiSearch dom);

    List<InsuInsdMiEntity> selectInsuInsdMiList(InsuInsdMiSearch dom);
}
