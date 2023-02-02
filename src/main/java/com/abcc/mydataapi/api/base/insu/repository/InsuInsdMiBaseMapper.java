package com.abcc.mydataapi.api.base.insu.repository;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdMiBaseEntity;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdMiBaseSearch;
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
