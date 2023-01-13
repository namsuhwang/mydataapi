package com.kpcnc.mydataapi.api.base.insu.repository;

import com.kpcnc.mydataapi.api.base.insu.models.InsuSccontSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuSccontEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuSccontMapper{
    int insertInsuSccont(InsuSccontEntity dom);

    int updateInsuSccont(InsuSccontEntity dom);

    int deleteInsuSccont(InsuSccontEntity dom);

    InsuSccontEntity selectInsuSccont(InsuSccontSearch dom);

    Long selectInsuSccontListTotalCnt(InsuSccontSearch dom);

    List<InsuSccontEntity> selectInsuSccontList(InsuSccontSearch dom);
}
