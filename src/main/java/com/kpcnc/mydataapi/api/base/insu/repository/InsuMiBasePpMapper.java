package com.kpcnc.mydataapi.api.base.insu.repository;

import com.kpcnc.mydataapi.api.base.insu.models.InsuMiBasePpSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuMiBasePpEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuMiBasePpMapper{
    int insertInsuMiBasePp(InsuMiBasePpEntity dom);

    int updateInsuMiBasePp(InsuMiBasePpEntity dom);

    int deleteInsuMiBasePp(InsuMiBasePpEntity dom);

    int deleteAllInsuMiBasePp(InsuMiBasePpEntity dom);

    InsuMiBasePpEntity selectInsuMiBasePp(InsuMiBasePpSearch dom);

    Long selectInsuMiBasePpListTotalCnt(InsuMiBasePpSearch dom);

    List<InsuMiBasePpEntity> selectInsuMiBasePpList(InsuMiBasePpSearch dom);
}
