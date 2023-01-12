package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiSccontSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiSccontEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdMiSccontMapper{
    int insertInsuInsdMiSccont(InsuInsdMiSccontEntity dom);

    int updateInsuInsdMiSccont(InsuInsdMiSccontEntity dom);

    int deleteInsuInsdMiSccont(InsuInsdMiSccontEntity dom);

    InsuInsdMiSccontEntity selectInsuInsdMiSccont(InsuInsdMiSccontSearch dom);

    Long selectInsuInsdMiSccontListTotalCnt(InsuInsdMiSccontSearch dom);

    List<InsuInsdMiSccontEntity> selectInsuInsdMiSccontList(InsuInsdMiSccontSearch dom);
}
