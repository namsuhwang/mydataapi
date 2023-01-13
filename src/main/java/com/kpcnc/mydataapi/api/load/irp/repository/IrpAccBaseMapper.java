package com.kpcnc.mydataapi.api.load.irp.repository;

import com.kpcnc.mydataapi.api.load.irp.models.IrpAccBaseSearch;
import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccBaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IrpAccBaseMapper{
    int insertIrpAccBase(IrpAccBaseEntity dom);

    int updateIrpAccBase(IrpAccBaseEntity dom);

    int deleteIrpAccBase(IrpAccBaseEntity dom);

    IrpAccBaseEntity selectIrpAccBase(IrpAccBaseSearch dom);

    Long selectIrpAccBaseListTotalCnt(IrpAccBaseSearch dom);

    List<IrpAccBaseEntity> selectIrpAccBaseList(IrpAccBaseSearch dom);
}
