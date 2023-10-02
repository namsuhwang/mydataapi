package com.albee.mydataapi.api.base.invt.service;

import com.albee.mydataapi.api.base.invt.models.InvtAccProdBaseDateSearch;
import com.albee.mydataapi.api.base.invt.models.entity.InvtAccProdBaseDateEntity;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccProdBaseDateForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface InvtAccProdBaseDateService{
    public void regInvtAccProdBaseDate(InvtAccProdBaseDateForm dom);

    public void updInvtAccProdBaseDate(InvtAccProdBaseDateForm dom);

    public void modInvtAccProdBaseDate(InvtAccProdBaseDateForm dom);

    public void delInvtAccProdBaseDate(InvtAccProdBaseDateForm dom);

    public InvtAccProdBaseDateEntity getInvtAccProdBaseDate(InvtAccProdBaseDateSearch dom);

    public ResultListDto<InvtAccProdBaseDateEntity> getInvtAccProdBaseDateList(InvtAccProdBaseDateSearch dom);
}
