package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuGurtSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuGurtEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuGurtMapper{
    int insertInsuGurt(InsuGurtEntity dom);

    int updateInsuGurt(InsuGurtEntity dom);

    int deleteInsuGurt(InsuGurtEntity dom);

    InsuGurtEntity selectInsuGurt(InsuGurtSearch dom);

    Long selectInsuGurtListTotalCnt(InsuGurtSearch dom);

    List<InsuGurtEntity> selectInsuGurtList(InsuGurtSearch dom);
}
