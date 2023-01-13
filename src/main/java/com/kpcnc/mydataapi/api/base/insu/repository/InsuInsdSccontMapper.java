package com.kpcnc.mydataapi.api.base.insu.repository;

import com.kpcnc.mydataapi.api.base.insu.models.InsuInsdSccontSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuInsdSccontEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdSccontMapper{
    int insertInsuInsdSccont(InsuInsdSccontEntity dom);

    int updateInsuInsdSccont(InsuInsdSccontEntity dom);

    int deleteInsuInsdSccont(InsuInsdSccontEntity dom);

    InsuInsdSccontEntity selectInsuInsdSccont(InsuInsdSccontSearch dom);

    Long selectInsuInsdSccontListTotalCnt(InsuInsdSccontSearch dom);

    List<InsuInsdSccontEntity> selectInsuInsdSccontList(InsuInsdSccontSearch dom);
}
