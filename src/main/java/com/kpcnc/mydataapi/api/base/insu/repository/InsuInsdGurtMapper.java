package com.kpcnc.mydataapi.api.base.insu.repository;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdGurtSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdGurtEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdGurtMapper{
    int insertInsuInsdGurt(InsuInsdGurtEntity dom);

    int updateInsuInsdGurt(InsuInsdGurtEntity dom);

    int deleteInsuInsdGurt(InsuInsdGurtEntity dom);

    int deleteAllInsuInsdGurt(InsuInsdGurtEntity dom);

    InsuInsdGurtEntity selectInsuInsdGurt(InsuInsdGurtSearch dom);

    InsuInsdGurtEntity selectInsuInsdGurtLast(InsuInsdGurtSearch dom);

    Long selectInsuInsdGurtListTotalCnt(InsuInsdGurtSearch dom);

    List<InsuInsdGurtEntity> selectInsuInsdGurtList(InsuInsdGurtSearch dom);
}
