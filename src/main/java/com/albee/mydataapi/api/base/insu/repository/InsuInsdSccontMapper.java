package com.albee.mydataapi.api.base.insu.repository;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdSccontEntity;
import com.albee.mydataapi.api.base.insu.models.InsuInsdSccontSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdSccontMapper{
    int insertInsuInsdSccont(InsuInsdSccontEntity dom);

    int updateInsuInsdSccont(InsuInsdSccontEntity dom);

    int deleteInsuInsdSccont(InsuInsdSccontEntity dom);

    InsuInsdSccontEntity selectInsuInsdSccont(InsuInsdSccontSearch dom);

    InsuInsdSccontEntity selectInsuInsdSccontLast(InsuInsdSccontSearch dom);

    Long selectInsuInsdSccontListTotalCnt(InsuInsdSccontSearch dom);

    List<InsuInsdSccontEntity> selectInsuInsdSccontList(InsuInsdSccontSearch dom);
}
