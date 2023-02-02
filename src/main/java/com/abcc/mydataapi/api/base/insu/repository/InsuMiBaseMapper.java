package com.abcc.mydataapi.api.base.insu.repository;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuMiBaseEntity;
import com.abcc.mydataapi.api.base.insu.models.InsuMiBaseSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuMiBaseMapper{
    int insertInsuMiBase(InsuMiBaseEntity dom);

    int updateInsuMiBase(InsuMiBaseEntity dom);

    int deleteInsuMiBase(InsuMiBaseEntity dom);

    int deleteAllInsuMiBase(InsuMiBaseEntity dom);

    InsuMiBaseEntity selectInsuMiBase(InsuMiBaseSearch dom);

    Long selectInsuMiBaseListTotalCnt(InsuMiBaseSearch dom);

    List<InsuMiBaseEntity> selectInsuMiBaseList(InsuMiBaseSearch dom);
}
