package com.abcc.mydataapi.api.base.irp.service;

import com.abcc.mydataapi.api.base.irp.models.IrpAccSearch;
import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccEntity;
import com.abcc.mydataapi.api.base.irp.models.form.IrpAccForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface IrpAccService{
    public IrpAccEntity regIrpAcc(IrpAccForm dom);

    public IrpAccEntity modIrpAcc(IrpAccForm dom);

    public void  delIrpAcc(IrpAccForm dom);

    public void  allDelIrpAcc(IrpAccForm dom);

    public IrpAccEntity getIrpAcc(IrpAccSearch dom);

    public ResultListDto<IrpAccEntity> getIrpAccList(IrpAccSearch dom);
}
