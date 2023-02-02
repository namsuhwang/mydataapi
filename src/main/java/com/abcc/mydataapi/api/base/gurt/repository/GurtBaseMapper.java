package com.abcc.mydataapi.api.base.gurt.repository;

import com.abcc.mydataapi.api.base.gurt.models.GurtBaseSearch;
import com.abcc.mydataapi.api.base.gurt.models.entity.GurtBaseEntity;
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
