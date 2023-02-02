package com.abcc.mydataapi.api.base.irp.repository;

import com.abcc.mydataapi.api.base.irp.models.IrpAccBaseSearch;
import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccBaseEntity;
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
