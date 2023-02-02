package com.abcc.mydataapi.api.base.gurt.repository;

import com.abcc.mydataapi.api.base.gurt.models.GurtHistSearch;
import com.abcc.mydataapi.api.base.gurt.models.entity.GurtHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GurtHistMapper{
    int insertGurtHist(GurtHistEntity dom);

    int updateGurtHist(GurtHistEntity dom);

    int deleteGurtHist(GurtHistEntity dom);

    GurtHistEntity selectGurtHist(GurtHistSearch dom);

    Long selectGurtHistListTotalCnt(GurtHistSearch dom);

    List<GurtHistEntity> selectGurtHistList(GurtHistSearch dom);
}
