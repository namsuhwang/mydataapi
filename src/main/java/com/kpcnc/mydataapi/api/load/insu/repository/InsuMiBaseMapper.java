package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuMiBaseSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuMiBaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuMiBaseMapper{
    int insertInsuMiBase(InsuMiBaseEntity dom);

    int updateInsuMiBase(InsuMiBaseEntity dom);

    int deleteInsuMiBase(InsuMiBaseEntity dom);

    InsuMiBaseEntity selectInsuMiBase(InsuMiBaseSearch dom);

    Long selectInsuMiBaseListTotalCnt(InsuMiBaseSearch dom);

    List<InsuMiBaseEntity> selectInsuMiBaseList(InsuMiBaseSearch dom);
}
