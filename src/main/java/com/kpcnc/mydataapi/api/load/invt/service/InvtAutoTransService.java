package com.kpcnc.mydataapi.api.load.invt.service;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAutoTransSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAutoTransEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtAutoTransForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InvtAutoTransService{
    public InvtAutoTransEntity regInvtAutoTrans(InvtAutoTransForm dom);

    public InvtAutoTransEntity modInvtAutoTrans(InvtAutoTransForm dom);

    public void  delInvtAutoTrans(InvtAutoTransForm dom);

    public InvtAutoTransEntity getInvtAutoTrans(InvtAutoTransSearch dom);

    public ResultListDto<InvtAutoTransEntity> getInvtAutoTransList(InvtAutoTransSearch dom);
}
