package com.albee.mydataapi.api.base.gurt.repository;

import com.albee.mydataapi.api.base.gurt.models.GurtSearch;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GurtMapper{
    int insertGurt(GurtEntity dom);

    int updateGurt(GurtEntity dom);

    int deleteGurt(GurtEntity dom);

    int deleteAllGurt(GurtEntity dom);

    GurtEntity selectGurt(GurtSearch dom);

    GurtEntity selectGurtLast(GurtSearch dom);

    Long selectGurtListTotalCnt(GurtSearch dom);

    List<GurtEntity> selectGurtList(GurtSearch dom);
}
