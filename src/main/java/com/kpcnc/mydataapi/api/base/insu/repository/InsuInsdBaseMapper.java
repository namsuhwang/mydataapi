package com.kpcnc.mydataapi.api.base.insu.repository;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdBaseSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdBaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdBaseMapper{
    int insertInsuInsdBase(InsuInsdBaseEntity dom);

    int updateInsuInsdBase(InsuInsdBaseEntity dom);

    int deleteInsuInsdBase(InsuInsdBaseEntity dom);

    InsuInsdBaseEntity selectInsuInsdBase(InsuInsdBaseSearch dom);

    Long selectInsuInsdBaseListTotalCnt(InsuInsdBaseSearch dom);

    List<InsuInsdBaseEntity> selectInsuInsdBaseList(InsuInsdBaseSearch dom);
}