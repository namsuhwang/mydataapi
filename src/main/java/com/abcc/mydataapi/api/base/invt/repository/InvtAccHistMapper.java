package com.abcc.mydataapi.api.base.invt.repository;

import com.abcc.mydataapi.api.base.invt.models.InvtAccHistSearch;
import com.abcc.mydataapi.api.base.invt.models.entity.InvtAccHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvtAccHistMapper{
    int insertInvtAccHist(InvtAccHistEntity dom);

    int updateInvtAccHist(InvtAccHistEntity dom);

    int deleteInvtAccHist(InvtAccHistEntity dom);

    InvtAccHistEntity selectInvtAccHist(InvtAccHistSearch dom);

    InvtAccHistEntity selectInvtAccHistLast(InvtAccHistSearch dom);

    Long selectInvtAccHistListTotalCnt(InvtAccHistSearch dom);

    List<InvtAccHistEntity> selectInvtAccHistList(InvtAccHistSearch dom);
}
