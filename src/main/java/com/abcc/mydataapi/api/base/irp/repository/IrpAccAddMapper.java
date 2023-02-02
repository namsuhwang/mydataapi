package com.abcc.mydataapi.api.base.irp.repository;

import com.abcc.mydataapi.api.base.irp.models.IrpAccAddSearch;
import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccAddEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IrpAccAddMapper{
    int insertIrpAccAdd(IrpAccAddEntity dom);

    int updateIrpAccAdd(IrpAccAddEntity dom);

    int deleteIrpAccAdd(IrpAccAddEntity dom);

    int deleteAllIrpAccAdd(IrpAccAddEntity dom);

    IrpAccAddEntity selectIrpAccAdd(IrpAccAddSearch dom);

    IrpAccAddEntity selectIrpAccAddLast(IrpAccAddSearch dom);

    Long selectIrpAccAddListTotalCnt(IrpAccAddSearch dom);

    List<IrpAccAddEntity> selectIrpAccAddList(IrpAccAddSearch dom);
}
