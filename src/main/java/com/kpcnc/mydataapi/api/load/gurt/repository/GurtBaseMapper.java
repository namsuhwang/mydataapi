package com.kpcnc.mydataapi.api.load.gurt.repository;

import com.kpcnc.mydataapi.api.load.gurt.models.GurtBaseSearch;
import com.kpcnc.mydataapi.api.load.gurt.models.entity.GurtBaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GurtBaseMapper{
    int insertGurtBase(GurtBaseEntity dom);

    int updateGurtBase(GurtBaseEntity dom);

    int deleteGurtBase(GurtBaseEntity dom);

    GurtBaseEntity selectGurtBase(GurtBaseSearch dom);

    Long selectGurtBaseListTotalCnt(GurtBaseSearch dom);

    List<GurtBaseEntity> selectGurtBaseList(GurtBaseSearch dom);
}
