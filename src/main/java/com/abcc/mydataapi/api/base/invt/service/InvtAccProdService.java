package com.abcc.mydataapi.api.base.invt.service;

import com.abcc.mydataapi.api.base.invt.models.entity.InvtAccProdEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAccProdForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.invt.models.InvtAccProdSearch;

public interface InvtAccProdService{
    public void regInvtAccProd(InvtAccProdForm dom);

    public void updInvtAccProd(InvtAccProdForm dom);

    public void modInvtAccProd(InvtAccProdForm dom);

    public void delInvtAccProd(InvtAccProdForm dom);

    public void allDelInvtAccProd(InvtAccProdForm dom);

    public InvtAccProdEntity getInvtAccProd(InvtAccProdSearch dom);

    public ResultListDto<InvtAccProdEntity> getInvtAccProdList(InvtAccProdSearch dom);
}
