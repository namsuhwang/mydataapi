package com.kpcnc.mydataapi.api.base.irp.repository;

import com.kpcnc.mydataapi.api.base.irp.models.IrpAccSearch;
import com.kpcnc.mydataapi.api.base.irp.models.entity.IrpAccEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IrpAccMapper{
    int insertIrpAcc(IrpAccEntity dom);

    int updateIrpAcc(IrpAccEntity dom);

    int deleteIrpAcc(IrpAccEntity dom);

    IrpAccEntity selectIrpAcc(IrpAccSearch dom);

    Long selectIrpAccListTotalCnt(IrpAccSearch dom);

    List<IrpAccEntity> selectIrpAccList(IrpAccSearch dom);
}
