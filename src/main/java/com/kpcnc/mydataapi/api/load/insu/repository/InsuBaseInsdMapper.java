package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuBaseInsdSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuBaseInsdEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuBaseInsdMapper{
    int insertInsuBaseInsd(InsuBaseInsdEntity dom);

    int updateInsuBaseInsd(InsuBaseInsdEntity dom);

    int deleteInsuBaseInsd(InsuBaseInsdEntity dom);

    InsuBaseInsdEntity selectInsuBaseInsd(InsuBaseInsdSearch dom);

    Long selectInsuBaseInsdListTotalCnt(InsuBaseInsdSearch dom);

    List<InsuBaseInsdEntity> selectInsuBaseInsdList(InsuBaseInsdSearch dom);
}
