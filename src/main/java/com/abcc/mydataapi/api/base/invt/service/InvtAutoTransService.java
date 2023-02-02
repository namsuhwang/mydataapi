package com.abcc.mydataapi.api.base.invt.service;

import com.abcc.mydataapi.api.base.invt.models.InvtAutoTransSearch;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.invt.models.entity.InvtAutoTransEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAutoTransForm;

public interface InvtAutoTransService{
    public void regInvtAutoTrans(InvtAutoTransForm dom);

    public void updInvtAutoTrans(InvtAutoTransForm dom);

    public void modInvtAutoTrans(InvtAutoTransForm dom);

    public void delInvtAutoTrans(InvtAutoTransForm dom);;

    public void allDelInvtAutoTrans(InvtAutoTransForm dom);

    public InvtAutoTransEntity getInvtAutoTrans(InvtAutoTransSearch dom);

    public InvtAutoTransEntity getInvtAutoTransLast(InvtAutoTransSearch dom);

    public ResultListDto<InvtAutoTransEntity> getInvtAutoTransList(InvtAutoTransSearch dom);
}
