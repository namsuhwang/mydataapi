package com.kpcnc.mydataapi.api.base.invt.repository;

import com.kpcnc.mydataapi.api.base.invt.models.InvtAccSearch;
import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtAccEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvtAccMapper{
    int insertInvtAcc(InvtAccEntity dom);

    int updateInvtAcc(InvtAccEntity dom);

    int deleteInvtAcc(InvtAccEntity dom);

    int deleteAllInvtAcc(InvtAccEntity dom);

    InvtAccEntity selectInvtAcc(InvtAccSearch dom);

    Long selectInvtAccListTotalCnt(InvtAccSearch dom);

    List<InvtAccEntity> selectInvtAccList(InvtAccSearch dom);
}
