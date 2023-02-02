package com.abcc.mydataapi.api.base.insu.repository;

import com.abcc.mydataapi.api.base.insu.models.entity.InsuMiPayEntity;
import com.abcc.mydataapi.api.base.insu.models.InsuMiPaySearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsuMiPayMapper{
    int insertInsuMiPay(InsuMiPayEntity dom);

    int updateInsuMiPay(InsuMiPayEntity dom);

    int deleteInsuMiPay(InsuMiPayEntity dom);

    InsuMiPayEntity selectInsuMiPay(InsuMiPaySearch dom);

    Long selectInsuMiPayListTotalCnt(InsuMiPaySearch dom);

    List<InsuMiPayEntity> selectInsuMiPayList(InsuMiPaySearch dom);
}
