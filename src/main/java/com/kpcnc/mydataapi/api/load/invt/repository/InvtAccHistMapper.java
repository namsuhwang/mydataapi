package com.kpcnc.mydataapi.api.load.invt.repository;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAccHistSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvtAccHistMapper{
    int insertInvtAccHist(InvtAccHistEntity dom);

    int updateInvtAccHist(InvtAccHistEntity dom);

    int deleteInvtAccHist(InvtAccHistEntity dom);

    InvtAccHistEntity selectInvtAccHist(InvtAccHistSearch dom);

    Long selectInvtAccHistListTotalCnt(InvtAccHistSearch dom);

    List<InvtAccHistEntity> selectInvtAccHistList(InvtAccHistSearch dom);
}
