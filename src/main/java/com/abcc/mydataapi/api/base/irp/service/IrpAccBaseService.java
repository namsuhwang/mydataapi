package com.abcc.mydataapi.api.base.irp.service;

import com.abcc.mydataapi.api.base.irp.models.IrpAccBaseSearch;
import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccBaseEntity;
import com.abcc.mydataapi.api.base.irp.models.form.IrpAccBaseForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface IrpAccBaseService{
    public IrpAccBaseEntity regIrpAccBase(IrpAccBaseForm dom);

    public IrpAccBaseEntity modIrpAccBase(IrpAccBaseForm dom);

    public void  delIrpAccBase(IrpAccBaseForm dom);

    public IrpAccBaseEntity getIrpAccBase(IrpAccBaseSearch dom);

    public ResultListDto<IrpAccBaseEntity> getIrpAccBaseList(IrpAccBaseSearch dom);
}
