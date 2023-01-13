package com.kpcnc.mydataapi.api.base.irp.service.impl;

import com.kpcnc.mydataapi.api.base.irp.models.IrpAccSearch;
import com.kpcnc.mydataapi.api.base.irp.models.entity.IrpAccEntity;
import com.kpcnc.mydataapi.api.base.irp.models.form.IrpAccForm;
import com.kpcnc.mydataapi.api.base.irp.repository.IrpAccMapper;
import com.kpcnc.mydataapi.api.base.irp.service.IrpAccService;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;
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
public class IrpAccServiceImpl implements IrpAccService {
    @Autowired
    IrpAccMapper irpAccMapper;

    @Override
    public IrpAccEntity regIrpAcc(IrpAccForm dom) {
        irpAccMapper.insertIrpAcc(dom.getEntity());
        return irpAccMapper.selectIrpAcc(new IrpAccSearch(dom));
    }

    @Override
    public IrpAccEntity modIrpAcc(IrpAccForm dom) {
        irpAccMapper.updateIrpAcc(dom.getEntity());
        return irpAccMapper.selectIrpAcc(new IrpAccSearch(dom));
    }

    @Override
    public void delIrpAcc(IrpAccForm dom) {
        irpAccMapper.deleteIrpAcc(dom.getEntity());
        return;
    }

    @Override
    public IrpAccEntity getIrpAcc(IrpAccSearch dom) {
        return irpAccMapper.selectIrpAcc(dom);
    }

    @Override
    public ResultListDto<IrpAccEntity> getIrpAccList(IrpAccSearch dom) {
        ResultListDto<IrpAccEntity> result = new ResultListDto<>();
        Long totalCnt = irpAccMapper.selectIrpAccListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<IrpAccEntity> list = irpAccMapper.selectIrpAccList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
