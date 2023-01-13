package com.kpcnc.mydataapi.api.base.invt.service;

import com.kpcnc.mydataapi.api.base.invt.models.InvtAccBaseSearch;
import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtAccBaseEntity;
import com.kpcnc.mydataapi.api.base.invt.models.form.InvtAccBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InvtAccBaseService{
    public InvtAccBaseEntity regInvtAccBase(InvtAccBaseForm dom);

    public InvtAccBaseEntity modInvtAccBase(InvtAccBaseForm dom);

    public void  delInvtAccBase(InvtAccBaseForm dom);

    public InvtAccBaseEntity getInvtAccBase(InvtAccBaseSearch dom);

    public ResultListDto<InvtAccBaseEntity> getInvtAccBaseList(InvtAccBaseSearch dom);
}
