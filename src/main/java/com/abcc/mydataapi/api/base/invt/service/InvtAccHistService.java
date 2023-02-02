package com.abcc.mydataapi.api.base.invt.service;

import com.abcc.mydataapi.api.base.invt.models.InvtAccHistSearch;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.invt.models.entity.InvtAccHistEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAccHistForm;

public interface InvtAccHistService{
    public void regInvtAccHist(InvtAccHistForm dom);

    public void updInvtAccHist(InvtAccHistForm dom);

    public void modInvtAccHist(InvtAccHistForm dom);

    public void delInvtAccHist(InvtAccHistForm dom);

    public InvtAccHistEntity getInvtAccHist(InvtAccHistSearch dom);

    public InvtAccHistEntity getInvtAccHistLast(InvtAccHistSearch dom);

    public ResultListDto<InvtAccHistEntity> getInvtAccHistList(InvtAccHistSearch dom);
}
