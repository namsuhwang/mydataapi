package com.kpcnc.mydataapi.api.base.invt.service;

import com.kpcnc.mydataapi.api.base.invt.models.InvtPensionAccAddSearch;
import com.kpcnc.mydataapi.api.base.invt.models.entity.InvtPensionAccAddEntity;
import com.kpcnc.mydataapi.api.base.invt.models.form.InvtPensionAccAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface InvtPensionAccAddService{
    public InvtPensionAccAddEntity regInvtPensionAccAdd(InvtPensionAccAddForm dom);

    public InvtPensionAccAddEntity modInvtPensionAccAdd(InvtPensionAccAddForm dom);

    public void  delInvtPensionAccAdd(InvtPensionAccAddForm dom);

    public InvtPensionAccAddEntity getInvtPensionAccAdd(InvtPensionAccAddSearch dom);

    public ResultListDto<InvtPensionAccAddEntity> getInvtPensionAccAddList(InvtPensionAccAddSearch dom);
}
