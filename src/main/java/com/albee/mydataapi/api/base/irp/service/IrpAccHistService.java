package com.albee.mydataapi.api.base.irp.service;

import com.albee.mydataapi.api.base.irp.models.IrpAccHistSearch;
import com.albee.mydataapi.api.base.irp.models.entity.IrpAccHistEntity;
import com.albee.mydataapi.api.base.irp.models.form.IrpAccHistForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface IrpAccHistService{
    public IrpAccHistEntity regIrpAccHist(IrpAccHistForm dom);

    public IrpAccHistEntity modIrpAccHist(IrpAccHistForm dom);

    public void  delIrpAccHist(IrpAccHistForm dom);

    public IrpAccHistEntity getIrpAccHist(IrpAccHistSearch dom);

    public IrpAccHistEntity getIrpAccHistLast(IrpAccHistSearch dom);

    public ResultListDto<IrpAccHistEntity> getIrpAccHistList(IrpAccHistSearch dom);
}
