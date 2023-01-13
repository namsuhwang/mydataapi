package com.kpcnc.mydataapi.api.base.invt.repository;

import com.kpcnc.mydataapi.api.base.invt.models.InvtAccBaseSearch;
import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtAccBaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvtAccBaseMapper{
    int insertInvtAccBase(InvtAccBaseEntity dom);

    int updateInvtAccBase(InvtAccBaseEntity dom);

    int deleteInvtAccBase(InvtAccBaseEntity dom);

    InvtAccBaseEntity selectInvtAccBase(InvtAccBaseSearch dom);

    Long selectInvtAccBaseListTotalCnt(InvtAccBaseSearch dom);

    List<InvtAccBaseEntity> selectInvtAccBaseList(InvtAccBaseSearch dom);
}
