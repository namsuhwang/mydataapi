package com.kpcnc.mydataapi.api.load.irp.repository;

import com.kpcnc.mydataapi.api.load.irp.models.IrpAccHistSearch;
import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccHistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IrpAccHistMapper{
    int insertIrpAccHist(IrpAccHistEntity dom);

    int updateIrpAccHist(IrpAccHistEntity dom);

    int deleteIrpAccHist(IrpAccHistEntity dom);

    IrpAccHistEntity selectIrpAccHist(IrpAccHistSearch dom);

    Long selectIrpAccHistListTotalCnt(IrpAccHistSearch dom);

    List<IrpAccHistEntity> selectIrpAccHistList(IrpAccHistSearch dom);
}
