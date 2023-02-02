package com.albee.mydataapi.api.base.invt.service;

import com.albee.mydataapi.api.base.invt.models.InvtPensionAccAddSearch;
import com.albee.mydataapi.api.base.invt.models.entity.InvtPensionAccAddEntity;
import com.albee.mydataapi.api.base.invt.models.form.InvtPensionAccAddForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface InvtPensionAccAddService{
    public void regInvtPensionAccAdd(InvtPensionAccAddForm dom);

    public void updInvtPensionAccAdd(InvtPensionAccAddForm dom);

    public void modInvtPensionAccAdd(InvtPensionAccAddForm dom);

    public void delInvtPensionAccAdd(InvtPensionAccAddForm dom);

    public InvtPensionAccAddEntity getInvtPensionAccAdd(InvtPensionAccAddSearch dom);

    public ResultListDto<InvtPensionAccAddEntity> getInvtPensionAccAddList(InvtPensionAccAddSearch dom);
}
