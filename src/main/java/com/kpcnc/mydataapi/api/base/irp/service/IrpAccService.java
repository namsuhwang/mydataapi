package com.kpcnc.mydataapi.api.base.irp.service;

import com.kpcnc.mydataapi.api.base.bank.models.form.BankAccForm;
import com.kpcnc.mydataapi.api.base.irp.models.IrpAccSearch;
import com.kpcnc.mydataapi.api.base.irp.models.entity.IrpAccEntity;
import com.kpcnc.mydataapi.api.base.irp.models.form.IrpAccForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface IrpAccService{
    public IrpAccEntity regIrpAcc(IrpAccForm dom);

    public IrpAccEntity modIrpAcc(IrpAccForm dom);

    public void  delIrpAcc(IrpAccForm dom);

    public void  allDelIrpAcc(IrpAccForm dom);

    public IrpAccEntity getIrpAcc(IrpAccSearch dom);

    public ResultListDto<IrpAccEntity> getIrpAccList(IrpAccSearch dom);
}
