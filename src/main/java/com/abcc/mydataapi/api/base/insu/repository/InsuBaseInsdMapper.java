package com.abcc.mydataapi.api.base.insu.repository;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuBaseInsdEntity;
import com.abcc.mydataapi.api.base.insu.models.InsuBaseInsdSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuBaseInsdMapper{
    int insertInsuBaseInsd(InsuBaseInsdEntity dom);

    int updateInsuBaseInsd(InsuBaseInsdEntity dom);

    int deleteInsuBaseInsd(InsuBaseInsdEntity dom);

    int deleteAllInsuBaseInsd(InsuBaseInsdEntity dom);

    InsuBaseInsdEntity selectInsuBaseInsd(InsuBaseInsdSearch dom);

    Long selectInsuBaseInsdListTotalCnt(InsuBaseInsdSearch dom);

    List<InsuBaseInsdEntity> selectInsuBaseInsdList(InsuBaseInsdSearch dom);
}
