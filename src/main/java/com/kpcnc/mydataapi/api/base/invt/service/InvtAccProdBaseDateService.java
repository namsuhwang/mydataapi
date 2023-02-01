package com.kpcnc.mydataapi.api.base.invt.service;

import com.kpcnc.mydataapi.api.base.invt.models.InvtAccProdBaseDateSearch;
import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtAccProdBaseDateEntity;
import com.kpcnc.mydataapi.api.base.invt.models.form.InvtAccProdBaseDateForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InvtAccProdBaseDateService{
    public void regInvtAccProdBaseDate(InvtAccProdBaseDateForm dom);

    public void updInvtAccProdBaseDate(InvtAccProdBaseDateForm dom);

    public void modInvtAccProdBaseDate(InvtAccProdBaseDateForm dom);

    public void delInvtAccProdBaseDate(InvtAccProdBaseDateForm dom);

    public InvtAccProdBaseDateEntity getInvtAccProdBaseDate(InvtAccProdBaseDateSearch dom);

    public ResultListDto<InvtAccProdBaseDateEntity> getInvtAccProdBaseDateList(InvtAccProdBaseDateSearch dom);
}
