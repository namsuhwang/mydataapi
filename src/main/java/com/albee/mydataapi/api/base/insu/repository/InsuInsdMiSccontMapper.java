package com.albee.mydataapi.api.base.insu.repository;

import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdMiSccontEntity;
import com.albee.mydataapi.api.base.insu.models.InsuInsdMiSccontSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdMiSccontMapper{
    int insertInsuInsdMiSccont(InsuInsdMiSccontEntity dom);

    int updateInsuInsdMiSccont(InsuInsdMiSccontEntity dom);

    int deleteInsuInsdMiSccont(InsuInsdMiSccontEntity dom);

    int deleteAllInsuInsdMiSccont(InsuInsdMiSccontEntity dom);

    InsuInsdMiSccontEntity selectInsuInsdMiSccont(InsuInsdMiSccontSearch dom);

    InsuInsdMiSccontEntity selectInsuInsdMiSccontLast(InsuInsdMiSccontSearch dom);

    Long selectInsuInsdMiSccontListTotalCnt(InsuInsdMiSccontSearch dom);

    List<InsuInsdMiSccontEntity> selectInsuInsdMiSccontList(InsuInsdMiSccontSearch dom);
}
