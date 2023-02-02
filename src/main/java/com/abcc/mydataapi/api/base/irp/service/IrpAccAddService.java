package com.abcc.mydataapi.api.base.irp.service;

import com.abcc.mydataapi.api.base.irp.models.IrpAccAddSearch;
import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccAddEntity;
import com.abcc.mydataapi.api.base.irp.models.form.IrpAccAddForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

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
