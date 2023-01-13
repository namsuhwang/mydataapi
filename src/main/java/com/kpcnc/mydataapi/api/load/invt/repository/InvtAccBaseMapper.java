package com.kpcnc.mydataapi.api.load.invt.repository;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAccBaseSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccBaseEntity;
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
