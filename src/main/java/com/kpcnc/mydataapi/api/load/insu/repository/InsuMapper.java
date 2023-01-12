package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuMapper{
    int insertInsu(InsuEntity dom);

    int updateInsu(InsuEntity dom);

    int deleteInsu(InsuEntity dom);

    InsuEntity selectInsu(InsuSearch dom);

    Long selectInsuListTotalCnt(InsuSearch dom);

    List<InsuEntity> selectInsuList(InsuSearch dom);
}
