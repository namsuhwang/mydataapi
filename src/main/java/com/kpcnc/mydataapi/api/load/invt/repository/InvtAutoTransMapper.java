package com.kpcnc.mydataapi.api.load.invt.repository;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAutoTransSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAutoTransEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvtAutoTransMapper{
    int insertInvtAutoTrans(InvtAutoTransEntity dom);

    int updateInvtAutoTrans(InvtAutoTransEntity dom);

    int deleteInvtAutoTrans(InvtAutoTransEntity dom);

    InvtAutoTransEntity selectInvtAutoTrans(InvtAutoTransSearch dom);

    Long selectInvtAutoTransListTotalCnt(InvtAutoTransSearch dom);

    List<InvtAutoTransEntity> selectInvtAutoTransList(InvtAutoTransSearch dom);
}
