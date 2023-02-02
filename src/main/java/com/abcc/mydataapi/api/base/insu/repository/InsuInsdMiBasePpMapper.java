package com.abcc.mydataapi.api.base.insu.repository;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuInsdMiBasePpEntity;
import com.abcc.mydataapi.api.base.insu.models.InsuInsdMiBasePpSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuInsdMiBasePpMapper{
    int insertInsuInsdMiBasePp(InsuInsdMiBasePpEntity dom);

    int updateInsuInsdMiBasePp(InsuInsdMiBasePpEntity dom);

    int deleteInsuInsdMiBasePp(InsuInsdMiBasePpEntity dom);

    int deleteAllInsuInsdMiBasePp(InsuInsdMiBasePpEntity dom);

    InsuInsdMiBasePpEntity selectInsuInsdMiBasePp(InsuInsdMiBasePpSearch dom);

    Long selectInsuInsdMiBasePpListTotalCnt(InsuInsdMiBasePpSearch dom);

    List<InsuInsdMiBasePpEntity> selectInsuInsdMiBasePpList(InsuInsdMiBasePpSearch dom);
}
