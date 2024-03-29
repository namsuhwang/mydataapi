package com.albee.mydataapi.api.base.insu.repository;

import com.albee.mydataapi.api.base.insu.models.entity.InsuCarHistEntity;
import com.albee.mydataapi.api.base.insu.models.InsuCarHistSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuCarHistMapper{
    int insertInsuCarHist(InsuCarHistEntity dom);

    int updateInsuCarHist(InsuCarHistEntity dom);

    int deleteInsuCarHist(InsuCarHistEntity dom);

    InsuCarHistEntity selectInsuCarHist(InsuCarHistSearch dom);

    InsuCarHistEntity selectInsuCarHistLast(InsuCarHistSearch dom);

    Long selectInsuCarHistListTotalCnt(InsuCarHistSearch dom);

    List<InsuCarHistEntity> selectInsuCarHistList(InsuCarHistSearch dom);
}
