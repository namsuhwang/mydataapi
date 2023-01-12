package com.kpcnc.mydataapi.api.load.gurt.repository;

import com.kpcnc.mydataapi.api.load.gurt.models.GurtHistSearch;
import com.kpcnc.mydataapi.api.load.gurt.models.entity.GurtHistEntity;
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
