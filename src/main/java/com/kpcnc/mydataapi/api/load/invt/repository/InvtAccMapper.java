package com.kpcnc.mydataapi.api.load.invt.repository;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAccSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvtAccMapper{
    int insertInvtAcc(InvtAccEntity dom);

    int updateInvtAcc(InvtAccEntity dom);

    int deleteInvtAcc(InvtAccEntity dom);

    InvtAccEntity selectInvtAcc(InvtAccSearch dom);

    Long selectInvtAccListTotalCnt(InvtAccSearch dom);

    List<InvtAccEntity> selectInvtAccList(InvtAccSearch dom);
}
