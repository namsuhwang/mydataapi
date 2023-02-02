package com.abcc.mydataapi.api.base.irp.repository;

import com.abcc.mydataapi.api.base.irp.models.IrpAccHistSearch;
import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IrpAccHistMapper{
    int insertIrpAccHist(IrpAccHistEntity dom);

    int updateIrpAccHist(IrpAccHistEntity dom);

    int deleteIrpAccHist(IrpAccHistEntity dom);

    IrpAccHistEntity selectIrpAccHist(IrpAccHistSearch dom);

    Long selectIrpAccHistListTotalCnt(IrpAccHistSearch dom);

    IrpAccHistEntity selectIrpAccHistLast(IrpAccHistSearch dom);

    List<IrpAccHistEntity> selectIrpAccHistList(IrpAccHistSearch dom);
}
