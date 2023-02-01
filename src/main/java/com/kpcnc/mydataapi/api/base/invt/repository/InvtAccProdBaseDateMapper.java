package com.kpcnc.mydataapi.api.base.invt.repository;

import com.kpcnc.mydataapi.api.base.invt.models.InvtAccProdBaseDateSearch;
import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtAccProdBaseDateEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvtAccProdBaseDateMapper{
    int insertInvtAccProdBaseDate(InvtAccProdBaseDateEntity dom);

    int updateInvtAccProdBaseDate(InvtAccProdBaseDateEntity dom);

    int deleteInvtAccProdBaseDate(InvtAccProdBaseDateEntity dom);

    InvtAccProdBaseDateEntity selectInvtAccProdBaseDate(InvtAccProdBaseDateSearch dom);

    Long selectInvtAccProdBaseDateListTotalCnt(InvtAccProdBaseDateSearch dom);

    List<InvtAccProdBaseDateEntity> selectInvtAccProdBaseDateList(InvtAccProdBaseDateSearch dom);
}
