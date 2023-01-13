package com.kpcnc.mydataapi.api.load.invt.service;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAccBaseSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccBaseEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtAccBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InvtAccBaseService{
    public InvtAccBaseEntity regInvtAccBase(InvtAccBaseForm dom);

    public InvtAccBaseEntity modInvtAccBase(InvtAccBaseForm dom);

    public void  delInvtAccBase(InvtAccBaseForm dom);

    public InvtAccBaseEntity getInvtAccBase(InvtAccBaseSearch dom);

    public ResultListDto<InvtAccBaseEntity> getInvtAccBaseList(InvtAccBaseSearch dom);
}
