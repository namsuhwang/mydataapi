package com.kpcnc.mydataapi.api.load.irp.service;

import com.kpcnc.mydataapi.api.load.irp.models.IrpAccSearch;
import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccEntity;
import com.kpcnc.mydataapi.api.load.irp.models.form.IrpAccForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface IrpAccService{
    public IrpAccEntity regIrpAcc(IrpAccForm dom);

    public IrpAccEntity modIrpAcc(IrpAccForm dom);

    public void  delIrpAcc(IrpAccForm dom);

    public IrpAccEntity getIrpAcc(IrpAccSearch dom);

    public ResultListDto<IrpAccEntity> getIrpAccList(IrpAccSearch dom);
}
