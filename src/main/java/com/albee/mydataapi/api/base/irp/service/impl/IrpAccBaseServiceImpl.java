package com.albee.mydataapi.api.base.irp.service.impl;

import com.albee.mydataapi.api.base.irp.models.IrpAccBaseSearch;
import com.albee.mydataapi.api.base.irp.models.form.IrpAccBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.irp.models.entity.IrpAccBaseEntity;
import com.albee.mydataapi.api.base.irp.repository.IrpAccBaseMapper;
import com.albee.mydataapi.api.base.irp.service.IrpAccBaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class IrpAccBaseServiceImpl implements IrpAccBaseService {
    @Autowired
    IrpAccBaseMapper irpAccBaseMapper;

    @Override
    public IrpAccBaseEntity regIrpAccBase(IrpAccBaseForm dom) {
        irpAccBaseMapper.insertIrpAccBase(dom.getEntity());
        return irpAccBaseMapper.selectIrpAccBase(new IrpAccBaseSearch(dom));
    }

    @Override
    public IrpAccBaseEntity modIrpAccBase(IrpAccBaseForm dom) {
        irpAccBaseMapper.updateIrpAccBase(dom.getEntity());
        return irpAccBaseMapper.selectIrpAccBase(new IrpAccBaseSearch(dom));
    }

    @Override
    public void delIrpAccBase(IrpAccBaseForm dom) {
        irpAccBaseMapper.deleteIrpAccBase(dom.getEntity());
        return;
    }

    @Override
    public IrpAccBaseEntity getIrpAccBase(IrpAccBaseSearch dom) {
        return irpAccBaseMapper.selectIrpAccBase(dom);
    }

    @Override
    public ResultListDto<IrpAccBaseEntity> getIrpAccBaseList(IrpAccBaseSearch dom) {
        ResultListDto<IrpAccBaseEntity> result = new ResultListDto<>();
        Long totalCnt = irpAccBaseMapper.selectIrpAccBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<IrpAccBaseEntity> list = irpAccBaseMapper.selectIrpAccBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
