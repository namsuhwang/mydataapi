package com.albee.mydataapi.api.base.invt.service;

import com.albee.mydataapi.api.base.invt.models.InvtAutoTransSearch;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.invt.models.entity.InvtAutoTransEntity;
import com.albee.mydataapi.api.base.invt.models.form.InvtAutoTransForm;

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
