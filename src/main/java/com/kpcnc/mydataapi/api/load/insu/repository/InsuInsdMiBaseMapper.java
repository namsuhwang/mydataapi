package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiBaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdMiBaseMapper{
    int insertInsuInsdMiBase(InsuInsdMiBaseEntity dom);

    int updateInsuInsdMiBase(InsuInsdMiBaseEntity dom);

    int deleteInsuInsdMiBase(InsuInsdMiBaseEntity dom);

    InsuInsdMiBaseEntity selectInsuInsdMiBase(InsuInsdMiBaseSearch dom);

    Long selectInsuInsdMiBaseListTotalCnt(InsuInsdMiBaseSearch dom);

    List<InsuInsdMiBaseEntity> selectInsuInsdMiBaseList(InsuInsdMiBaseSearch dom);
}
