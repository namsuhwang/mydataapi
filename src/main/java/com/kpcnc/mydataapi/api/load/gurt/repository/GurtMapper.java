package com.kpcnc.mydataapi.api.load.gurt.repository;

import com.kpcnc.mydataapi.api.load.gurt.models.GurtSearch;
import com.kpcnc.mydataapi.api.load.gurt.models.entity.GurtEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GurtMapper{
    int insertGurt(GurtEntity dom);

    int updateGurt(GurtEntity dom);

    int deleteGurt(GurtEntity dom);

    GurtEntity selectGurt(GurtSearch dom);

    Long selectGurtListTotalCnt(GurtSearch dom);

    List<GurtEntity> selectGurtList(GurtSearch dom);
}
