package com.kpcnc.mydataapi.api.load.irp.service;

import com.kpcnc.mydataapi.api.load.irp.models.IrpAccHistSearch;
import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccHistEntity;
import com.kpcnc.mydataapi.api.load.irp.models.form.IrpAccHistForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface IrpAccHistService{
    public IrpAccHistEntity regIrpAccHist(IrpAccHistForm dom);

    public IrpAccHistEntity modIrpAccHist(IrpAccHistForm dom);

    public void  delIrpAccHist(IrpAccHistForm dom);

    public IrpAccHistEntity getIrpAccHist(IrpAccHistSearch dom);

    public ResultListDto<IrpAccHistEntity> getIrpAccHistList(IrpAccHistSearch dom);
}
