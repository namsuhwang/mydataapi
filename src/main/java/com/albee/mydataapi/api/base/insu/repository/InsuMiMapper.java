package com.albee.mydataapi.api.base.insu.repository;

import com.albee.mydataapi.api.base.insu.models.entity.InsuMiEntity;
import com.albee.mydataapi.api.base.insu.models.InsuMiSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuMiMapper{
    int insertInsuMi(InsuMiEntity dom);

    int updateInsuMi(InsuMiEntity dom);

    int deleteInsuMi(InsuMiEntity dom);

    int deleteAllInsuMi(InsuMiEntity dom);

    InsuMiEntity selectInsuMi(InsuMiSearch dom);

    InsuMiEntity selectInsuMiLast(InsuMiSearch dom);

    Long selectInsuMiListTotalCnt(InsuMiSearch dom);

    List<InsuMiEntity> selectInsuMiList(InsuMiSearch dom);
}
