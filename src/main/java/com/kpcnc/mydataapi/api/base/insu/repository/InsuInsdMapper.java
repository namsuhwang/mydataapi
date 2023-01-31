package com.kpcnc.mydataapi.api.base.insu.repository;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdMapper{
    int insertInsuInsd(InsuInsdEntity dom);

    int updateInsuInsd(InsuInsdEntity dom);

    int deleteInsuInsd(InsuInsdEntity dom);

    int deleteAllInsuInsd(InsuInsdEntity dom);

    InsuInsdEntity selectInsuInsd(InsuInsdSearch dom);

    InsuInsdEntity selectInsuInsdLast(InsuInsdSearch dom);

    Long selectInsuInsdListTotalCnt(InsuInsdSearch dom);

    List<InsuInsdEntity> selectInsuInsdList(InsuInsdSearch dom);
}
