package com.kpcnc.mydataapi.api.base.insu.repository;

import com.kpcnc.mydataapi.api.base.insu.models.InsuBaseSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuBaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuBaseMapper{
    int insertInsuBase(InsuBaseEntity dom);

    int updateInsuBase(InsuBaseEntity dom);

    int deleteInsuBase(InsuBaseEntity dom);

    int deleteAllInsuBase(InsuBaseEntity dom);

    InsuBaseEntity selectInsuBase(InsuBaseSearch dom);

    Long selectInsuBaseListTotalCnt(InsuBaseSearch dom);

    List<InsuBaseEntity> selectInsuBaseList(InsuBaseSearch dom);
}
