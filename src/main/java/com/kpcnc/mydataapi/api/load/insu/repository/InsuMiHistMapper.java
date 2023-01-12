package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuMiHistSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuMiHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuMiHistMapper{
    int insertInsuMiHist(InsuMiHistEntity dom);

    int updateInsuMiHist(InsuMiHistEntity dom);

    int deleteInsuMiHist(InsuMiHistEntity dom);

    InsuMiHistEntity selectInsuMiHist(InsuMiHistSearch dom);

    Long selectInsuMiHistListTotalCnt(InsuMiHistSearch dom);

    List<InsuMiHistEntity> selectInsuMiHistList(InsuMiHistSearch dom);
}
