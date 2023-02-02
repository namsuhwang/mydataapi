package com.albee.mydataapi.api.base.invt.service;

import com.albee.mydataapi.api.base.invt.models.InvtAccBaseSearch;
import com.albee.mydataapi.api.base.invt.models.entity.InvtAccBaseEntity;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccBaseForm;

public interface InvtAccBaseService{
    public void regInvtAccBase(InvtAccBaseForm dom);

    public void updInvtAccBase(InvtAccBaseForm dom);

    public void modInvtAccBase(InvtAccBaseForm dom);

    public void delInvtAccBase(InvtAccBaseForm dom);

    public InvtAccBaseEntity getInvtAccBase(InvtAccBaseSearch dom);

    public ResultListDto<InvtAccBaseEntity> getInvtAccBaseList(InvtAccBaseSearch dom);
}
