package com.kpcnc.mydataapi.api.base.invt.service;

import com.kpcnc.mydataapi.api.base.invt.models.InvtAccHistSearch;
import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtAccHistEntity;
import com.kpcnc.mydataapi.api.base.invt.models.form.InvtAccHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InvtAccHistService{
    public void regInvtAccHist(InvtAccHistForm dom);

    public void updInvtAccHist(InvtAccHistForm dom);

    public void modInvtAccHist(InvtAccHistForm dom);

    public void delInvtAccHist(InvtAccHistForm dom);

    public InvtAccHistEntity getInvtAccHist(InvtAccHistSearch dom);

    public InvtAccHistEntity getInvtAccHistLast(InvtAccHistSearch dom);

    public ResultListDto<InvtAccHistEntity> getInvtAccHistList(InvtAccHistSearch dom);
}
