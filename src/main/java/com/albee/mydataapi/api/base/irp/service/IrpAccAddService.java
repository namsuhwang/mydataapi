package com.albee.mydataapi.api.base.irp.service;

import com.albee.mydataapi.api.base.irp.models.IrpAccAddSearch;
import com.albee.mydataapi.api.base.irp.models.entity.IrpAccAddEntity;
import com.albee.mydataapi.api.base.irp.models.form.IrpAccAddForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface IrpAccAddService{
    public void regIrpAccAdd(IrpAccAddForm dom);

    public void updIrpAccAdd(IrpAccAddForm dom);

    public void modIrpAccAdd(IrpAccAddForm dom);

    public void  delIrpAccAdd(IrpAccAddForm dom);

    public void  allDelIrpAccAdd(IrpAccAddForm dom);

    public IrpAccAddEntity getIrpAccAdd(IrpAccAddSearch dom);

    public IrpAccAddEntity getIrpAccAddLast(IrpAccAddSearch dom);

    public ResultListDto<IrpAccAddEntity> getIrpAccAddList(IrpAccAddSearch dom);
}
