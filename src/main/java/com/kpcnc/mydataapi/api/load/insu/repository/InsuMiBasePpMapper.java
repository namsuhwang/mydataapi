package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.InsuMiBasePpEntity;
import com.kpcnc.mydataapi.api.load.insu.models.InsuMiBasePpSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuMiBasePpMapper{
    int insertInsuMiBasePp(InsuMiBasePpEntity dom);

    int updateInsuMiBasePp(InsuMiBasePpEntity dom);

    int deleteInsuMiBasePp(InsuMiBasePpEntity dom);

    InsuMiBasePpEntity selectInsuMiBasePp(InsuMiBasePpSearch dom);

    Long selectInsuMiBasePpListTotalCnt(InsuMiBasePpSearch dom);

    List<InsuMiBasePpEntity> selectInsuMiBasePpList(InsuMiBasePpSearch dom);
}
