package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuMiSccontSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuMiSccontEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuMiSccontMapper{
    int insertInsuMiSccont(InsuMiSccontEntity dom);

    int updateInsuMiSccont(InsuMiSccontEntity dom);

    int deleteInsuMiSccont(InsuMiSccontEntity dom);

    InsuMiSccontEntity selectInsuMiSccont(InsuMiSccontSearch dom);

    Long selectInsuMiSccontListTotalCnt(InsuMiSccontSearch dom);

    List<InsuMiSccontEntity> selectInsuMiSccontList(InsuMiSccontSearch dom);
}
