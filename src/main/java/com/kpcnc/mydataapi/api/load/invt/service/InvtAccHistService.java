package com.kpcnc.mydataapi.api.load.invt.service;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAccHistSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccHistEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtAccHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface InvtAccHistService{
    public InvtAccHistEntity regInvtAccHist(InvtAccHistForm dom);

    public InvtAccHistEntity modInvtAccHist(InvtAccHistForm dom);

    public void  delInvtAccHist(InvtAccHistForm dom);

    public InvtAccHistEntity getInvtAccHist(InvtAccHistSearch dom);

    public ResultListDto<InvtAccHistEntity> getInvtAccHistList(InvtAccHistSearch dom);
}
