package com.kpcnc.mydataapi.api.load.irp.service;

import com.kpcnc.mydataapi.api.load.irp.models.IrpAccBaseSearch;
import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccBaseEntity;
import com.kpcnc.mydataapi.api.load.irp.models.form.IrpAccBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface IrpAccBaseService{
    public IrpAccBaseEntity regIrpAccBase(IrpAccBaseForm dom);

    public IrpAccBaseEntity modIrpAccBase(IrpAccBaseForm dom);

    public void  delIrpAccBase(IrpAccBaseForm dom);

    public IrpAccBaseEntity getIrpAccBase(IrpAccBaseSearch dom);

    public ResultListDto<IrpAccBaseEntity> getIrpAccBaseList(IrpAccBaseSearch dom);
}
