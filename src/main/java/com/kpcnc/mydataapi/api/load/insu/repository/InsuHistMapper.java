package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuHistSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuHistMapper{
    int insertInsuHist(InsuHistEntity dom);

    int updateInsuHist(InsuHistEntity dom);

    int deleteInsuHist(InsuHistEntity dom);

    InsuHistEntity selectInsuHist(InsuHistSearch dom);

    Long selectInsuHistListTotalCnt(InsuHistSearch dom);

    List<InsuHistEntity> selectInsuHistList(InsuHistSearch dom);
}
