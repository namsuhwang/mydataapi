package com.abcc.mydataapi.api.base.invt.service;

import com.abcc.mydataapi.api.base.invt.models.InvtAccSearch;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.invt.models.entity.InvtAccEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAccForm;

public interface InvtAccService{
    public void regInvtAcc(InvtAccForm dom);

    public void updInvtAcc(InvtAccForm dom);

    public void modInvtAcc(InvtAccForm dom);

    public void delInvtAcc(InvtAccForm dom);

    public void allDelInvtAcc(InvtAccForm dom);

    public InvtAccEntity getInvtAcc(InvtAccSearch dom);

    public ResultListDto<InvtAccEntity> getInvtAccList(InvtAccSearch dom);
}
