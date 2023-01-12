package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdGurtSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdGurtEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdGurtMapper{
    int insertInsuInsdGurt(InsuInsdGurtEntity dom);

    int updateInsuInsdGurt(InsuInsdGurtEntity dom);

    int deleteInsuInsdGurt(InsuInsdGurtEntity dom);

    InsuInsdGurtEntity selectInsuInsdGurt(InsuInsdGurtSearch dom);

    Long selectInsuInsdGurtListTotalCnt(InsuInsdGurtSearch dom);

    List<InsuInsdGurtEntity> selectInsuInsdGurtList(InsuInsdGurtSearch dom);
}
