package com.abcc.mydataapi.api.base.gurt.repository;

import com.abcc.mydataapi.api.base.gurt.models.GurtInsdSearch;
import com.abcc.mydataapi.api.base.gurt.models.entity.GurtInsdEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GurtInsdMapper{
    int insertGurtInsd(GurtInsdEntity dom);

    int updateGurtInsd(GurtInsdEntity dom);

    int deleteGurtInsd(GurtInsdEntity dom);

    GurtInsdEntity selectGurtInsd(GurtInsdSearch dom);

    Long selectGurtInsdListTotalCnt(GurtInsdSearch dom);

    List<GurtInsdEntity> selectGurtInsdList(GurtInsdSearch dom);
}
