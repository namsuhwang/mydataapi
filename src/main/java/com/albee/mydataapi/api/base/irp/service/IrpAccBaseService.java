package com.albee.mydataapi.api.base.irp.service;

import com.albee.mydataapi.api.base.irp.models.IrpAccBaseSearch;
import com.albee.mydataapi.api.base.irp.models.entity.IrpAccBaseEntity;
import com.albee.mydataapi.api.base.irp.models.form.IrpAccBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface IrpAccBaseService{
    public IrpAccBaseEntity regIrpAccBase(IrpAccBaseForm dom);

    public IrpAccBaseEntity modIrpAccBase(IrpAccBaseForm dom);

    public void  delIrpAccBase(IrpAccBaseForm dom);

    public IrpAccBaseEntity getIrpAccBase(IrpAccBaseSearch dom);

    public ResultListDto<IrpAccBaseEntity> getIrpAccBaseList(IrpAccBaseSearch dom);
}
