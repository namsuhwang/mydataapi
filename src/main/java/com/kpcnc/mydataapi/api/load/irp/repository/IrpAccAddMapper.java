package com.kpcnc.mydataapi.api.load.irp.repository;

import com.kpcnc.mydataapi.api.load.irp.models.IrpAccAddSearch;
import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccAddEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IrpAccAddMapper{
    int insertIrpAccAdd(IrpAccAddEntity dom);

    int updateIrpAccAdd(IrpAccAddEntity dom);

    int deleteIrpAccAdd(IrpAccAddEntity dom);

    IrpAccAddEntity selectIrpAccAdd(IrpAccAddSearch dom);

    Long selectIrpAccAddListTotalCnt(IrpAccAddSearch dom);

    List<IrpAccAddEntity> selectIrpAccAddList(IrpAccAddSearch dom);
}
