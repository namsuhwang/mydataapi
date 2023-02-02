package com.albee.mydataapi.api.base.irp.service;

import com.albee.mydataapi.api.base.irp.models.IrpAccSearch;
import com.albee.mydataapi.api.base.irp.models.entity.IrpAccEntity;
import com.albee.mydataapi.api.base.irp.models.form.IrpAccForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface IrpAccService{
    public IrpAccEntity regIrpAcc(IrpAccForm dom);

    public IrpAccEntity modIrpAcc(IrpAccForm dom);

    public void  delIrpAcc(IrpAccForm dom);

    public void  allDelIrpAcc(IrpAccForm dom);

    public IrpAccEntity getIrpAcc(IrpAccSearch dom);

    public ResultListDto<IrpAccEntity> getIrpAccList(IrpAccSearch dom);
}
