package com.kpcnc.mydataapi.api.base.invt.service;

import com.kpcnc.mydataapi.api.base.invt.models.InvtAutoTransSearch;
import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtAutoTransEntity;
import com.kpcnc.mydataapi.api.base.invt.models.form.InvtAutoTransForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InvtAutoTransService{
    public InvtAutoTransEntity regInvtAutoTrans(InvtAutoTransForm dom);

    public InvtAutoTransEntity modInvtAutoTrans(InvtAutoTransForm dom);

    public void  delInvtAutoTrans(InvtAutoTransForm dom);

    public InvtAutoTransEntity getInvtAutoTrans(InvtAutoTransSearch dom);

    public ResultListDto<InvtAutoTransEntity> getInvtAutoTransList(InvtAutoTransSearch dom);
}
