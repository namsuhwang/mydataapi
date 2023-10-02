package com.albee.mydataapi.api.base.insu.repository;

import com.albee.mydataapi.api.base.insu.models.entity.InsuMiHistEntity;
import com.albee.mydataapi.api.base.insu.models.InsuMiHistSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuMiHistMapper{
    int insertInsuMiHist(InsuMiHistEntity dom);

    int updateInsuMiHist(InsuMiHistEntity dom);

    int deleteInsuMiHist(InsuMiHistEntity dom);

    InsuMiHistEntity selectInsuMiHist(InsuMiHistSearch dom);

    InsuMiHistEntity selectInsuMiHistLast(InsuMiHistSearch dom);

    Long selectInsuMiHistListTotalCnt(InsuMiHistSearch dom);

    List<InsuMiHistEntity> selectInsuMiHistList(InsuMiHistSearch dom);
}
