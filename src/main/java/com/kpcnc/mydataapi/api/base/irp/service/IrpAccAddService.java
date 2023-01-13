package com.kpcnc.mydataapi.api.base.irp.service;

import com.kpcnc.mydataapi.api.base.irp.models.IrpAccAddSearch;
import com.kpcnc.mydataapi.api.base.irp.models.entity.IrpAccAddEntity;
import com.kpcnc.mydataapi.api.base.irp.models.form.IrpAccAddForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface IrpAccAddService{
    public IrpAccAddEntity regIrpAccAdd(IrpAccAddForm dom);

    public IrpAccAddEntity modIrpAccAdd(IrpAccAddForm dom);

    public void  delIrpAccAdd(IrpAccAddForm dom);

    public IrpAccAddEntity getIrpAccAdd(IrpAccAddSearch dom);

    public ResultListDto<IrpAccAddEntity> getIrpAccAddList(IrpAccAddSearch dom);
}
