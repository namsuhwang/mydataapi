package com.abcc.mydataapi.api.base.invt.service;

import com.abcc.mydataapi.api.base.invt.models.InvtPensionAccAddSearch;
import com.abcc.mydataapi.api.base.invt.models.entity.InvtPensionAccAddEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtPensionAccAddForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface InvtPensionAccAddService{
    public void regInvtPensionAccAdd(InvtPensionAccAddForm dom);

    public void updInvtPensionAccAdd(InvtPensionAccAddForm dom);

    public void modInvtPensionAccAdd(InvtPensionAccAddForm dom);

    public void delInvtPensionAccAdd(InvtPensionAccAddForm dom);

    public InvtPensionAccAddEntity getInvtPensionAccAdd(InvtPensionAccAddSearch dom);

    public ResultListDto<InvtPensionAccAddEntity> getInvtPensionAccAddList(InvtPensionAccAddSearch dom);
}
