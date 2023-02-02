package com.albee.mydataapi.api.base.insu.repository;

import com.albee.mydataapi.api.base.insu.models.entity.InsuSccontEntity;
import com.albee.mydataapi.api.base.insu.models.InsuSccontSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuSccontMapper{
    int insertInsuSccont(InsuSccontEntity dom);

    int updateInsuSccont(InsuSccontEntity dom);

    int deleteInsuSccont(InsuSccontEntity dom);

    int deleteAllInsuSccont(InsuSccontEntity dom);

    InsuSccontEntity selectInsuSccont(InsuSccontSearch dom);

    InsuSccontEntity selectInsuSccontLast(InsuSccontSearch dom);

    Long selectInsuSccontListTotalCnt(InsuSccontSearch dom);

    List<InsuSccontEntity> selectInsuSccontList(InsuSccontSearch dom);
}
