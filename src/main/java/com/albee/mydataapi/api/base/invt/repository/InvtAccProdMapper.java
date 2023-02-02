package com.albee.mydataapi.api.base.invt.repository;

import com.albee.mydataapi.api.base.invt.models.entity.InvtAccProdEntity;
import com.albee.mydataapi.api.base.invt.models.InvtAccProdSearch;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvtAccProdMapper{
    int insertInvtAccProd(InvtAccProdEntity dom);

    int updateInvtAccProd(InvtAccProdEntity dom);

    int deleteInvtAccProd(InvtAccProdEntity dom);

    int deleteAllInvtAccProd(InvtAccProdEntity dom);

    InvtAccProdEntity selectInvtAccProd(InvtAccProdSearch dom);

    Long selectInvtAccProdListTotalCnt(InvtAccProdSearch dom);

    List<InvtAccProdEntity> selectInvtAccProdList(InvtAccProdSearch dom);
}
