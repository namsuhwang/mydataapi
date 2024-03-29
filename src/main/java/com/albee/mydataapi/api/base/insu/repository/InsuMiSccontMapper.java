package com.albee.mydataapi.api.base.insu.repository;

import com.albee.mydataapi.api.base.insu.models.entity.InsuMiSccontEntity;
import com.albee.mydataapi.api.base.insu.models.InsuMiSccontSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuMiSccontMapper{
    int insertInsuMiSccont(InsuMiSccontEntity dom);

    int updateInsuMiSccont(InsuMiSccontEntity dom);

    int deleteInsuMiSccont(InsuMiSccontEntity dom);

    int deleteAllInsuMiSccont(InsuMiSccontEntity dom);

    InsuMiSccontEntity selectInsuMiSccont(InsuMiSccontSearch dom);

    InsuMiSccontEntity selectInsuMiSccontLast(InsuMiSccontSearch dom);

    Long selectInsuMiSccontListTotalCnt(InsuMiSccontSearch dom);

    List<InsuMiSccontEntity> selectInsuMiSccontList(InsuMiSccontSearch dom);
}
