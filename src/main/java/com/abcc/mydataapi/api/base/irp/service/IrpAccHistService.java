package com.abcc.mydataapi.api.base.irp.service;

import com.abcc.mydataapi.api.base.irp.models.IrpAccHistSearch;
import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccHistEntity;
import com.abcc.mydataapi.api.base.irp.models.form.IrpAccHistForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface IrpAccHistService{
    public IrpAccHistEntity regIrpAccHist(IrpAccHistForm dom);

    public IrpAccHistEntity modIrpAccHist(IrpAccHistForm dom);

    public void  delIrpAccHist(IrpAccHistForm dom);

    public IrpAccHistEntity getIrpAccHist(IrpAccHistSearch dom);

    public IrpAccHistEntity getIrpAccHistLast(IrpAccHistSearch dom);

    public ResultListDto<IrpAccHistEntity> getIrpAccHistList(IrpAccHistSearch dom);
}
