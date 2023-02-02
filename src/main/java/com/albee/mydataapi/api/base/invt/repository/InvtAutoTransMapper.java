package com.albee.mydataapi.api.base.invt.repository;

import com.albee.mydataapi.api.base.invt.models.InvtAutoTransSearch;
import com.albee.mydataapi.api.base.invt.models.entity.InvtAutoTransEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvtAutoTransMapper{
    int insertInvtAutoTrans(InvtAutoTransEntity dom);

    int updateInvtAutoTrans(InvtAutoTransEntity dom);

    int deleteInvtAutoTrans(InvtAutoTransEntity dom);

    int deleteAllInvtAutoTrans(InvtAutoTransEntity dom);

    InvtAutoTransEntity selectInvtAutoTrans(InvtAutoTransSearch dom);

    InvtAutoTransEntity selectInvtAutoTransLast(InvtAutoTransSearch dom);

    Long selectInvtAutoTransListTotalCnt(InvtAutoTransSearch dom);

    List<InvtAutoTransEntity> selectInvtAutoTransList(InvtAutoTransSearch dom);
}
