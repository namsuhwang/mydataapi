package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuPaySearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuPayEntity;
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
