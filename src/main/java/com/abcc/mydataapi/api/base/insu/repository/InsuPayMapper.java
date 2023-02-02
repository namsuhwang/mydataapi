package com.abcc.mydataapi.api.base.insu.repository;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuPayEntity;
import com.abcc.mydataapi.api.base.insu.models.InsuPaySearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuPayMapper{
    int insertInsuPay(InsuPayEntity dom);

    int updateInsuPay(InsuPayEntity dom);

    int deleteInsuPay(InsuPayEntity dom);

    InsuPayEntity selectInsuPay(InsuPaySearch dom);

    Long selectInsuPayListTotalCnt(InsuPaySearch dom);

    List<InsuPayEntity> selectInsuPayList(InsuPaySearch dom);
}
