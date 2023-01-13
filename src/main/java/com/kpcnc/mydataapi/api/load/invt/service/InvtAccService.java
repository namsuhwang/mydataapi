package com.kpcnc.mydataapi.api.load.invt.service;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAccSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtAccForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InvtAccService{
    public InvtAccEntity regInvtAcc(InvtAccForm dom);

    public InvtAccEntity modInvtAcc(InvtAccForm dom);

    public void  delInvtAcc(InvtAccForm dom);

    public InvtAccEntity getInvtAcc(InvtAccSearch dom);

    public ResultListDto<InvtAccEntity> getInvtAccList(InvtAccSearch dom);
}
