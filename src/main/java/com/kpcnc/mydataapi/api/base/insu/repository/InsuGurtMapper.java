package com.kpcnc.mydataapi.api.base.insu.repository;

import com.kpcnc.mydataapi.api.base.insu.models.InsuGurtSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuGurtEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuGurtMapper{
    int insertInsuGurt(InsuGurtEntity dom);

    int updateInsuGurt(InsuGurtEntity dom);

    int deleteInsuGurt(InsuGurtEntity dom);

    int deleteAllInsuGurt(InsuGurtEntity dom);

    InsuGurtEntity selectInsuGurt(InsuGurtSearch dom);

    InsuGurtEntity selectInsuGurtLast(InsuGurtSearch dom);

    Long selectInsuGurtListTotalCnt(InsuGurtSearch dom);

    List<InsuGurtEntity> selectInsuGurtList(InsuGurtSearch dom);
}
