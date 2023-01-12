package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuInsdMiBasePpSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuInsdMiBasePpEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdMiBasePpMapper{
    int insertInsuInsdMiBasePp(InsuInsdMiBasePpEntity dom);

    int updateInsuInsdMiBasePp(InsuInsdMiBasePpEntity dom);

    int deleteInsuInsdMiBasePp(InsuInsdMiBasePpEntity dom);

    InsuInsdMiBasePpEntity selectInsuInsdMiBasePp(InsuInsdMiBasePpSearch dom);

    Long selectInsuInsdMiBasePpListTotalCnt(InsuInsdMiBasePpSearch dom);

    List<InsuInsdMiBasePpEntity> selectInsuInsdMiBasePpList(InsuInsdMiBasePpSearch dom);
}
