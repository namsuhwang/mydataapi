package com.kpcnc.mydataapi.api.base.insu.repository;

import com.kpcnc.mydataapi.api.base.insu.models.InsuCarHistSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuCarHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuCarHistMapper{
    int insertInsuCarHist(InsuCarHistEntity dom);

    int updateInsuCarHist(InsuCarHistEntity dom);

    int deleteInsuCarHist(InsuCarHistEntity dom);

    InsuCarHistEntity selectInsuCarHist(InsuCarHistSearch dom);

    Long selectInsuCarHistListTotalCnt(InsuCarHistSearch dom);

    List<InsuCarHistEntity> selectInsuCarHistList(InsuCarHistSearch dom);
}
