package com.kpcnc.mydataapi.api.load.insu.repository;

import com.kpcnc.mydataapi.api.load.insu.models.InsuMiPaySearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuMiPayEntity;
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
