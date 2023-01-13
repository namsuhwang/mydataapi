package com.kpcnc.mydataapi.api.base.invt.repository;

import com.kpcnc.mydataapi.api.base.invt.models.InvtPensionAccAddSearch;
import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtPensionAccAddEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InvtPensionAccAddMapper{
    int insertInvtPensionAccAdd(InvtPensionAccAddEntity dom);

    int updateInvtPensionAccAdd(InvtPensionAccAddEntity dom);

    int deleteInvtPensionAccAdd(InvtPensionAccAddEntity dom);

    InvtPensionAccAddEntity selectInvtPensionAccAdd(InvtPensionAccAddSearch dom);

    Long selectInvtPensionAccAddListTotalCnt(InvtPensionAccAddSearch dom);

    List<InvtPensionAccAddEntity> selectInvtPensionAccAddList(InvtPensionAccAddSearch dom);
}
