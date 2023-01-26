package com.kpcnc.mydataapi.api.base.irp.service.impl;

import com.kpcnc.mydataapi.api.base.irp.models.IrpAccHistSearch;
import com.kpcnc.mydataapi.api.base.irp.models.entity.IrpAccHistEntity;
import com.kpcnc.mydataapi.api.base.irp.models.form.IrpAccHistForm;
import com.kpcnc.mydataapi.api.base.irp.repository.IrpAccHistMapper;
import com.kpcnc.mydataapi.api.base.irp.service.IrpAccHistService;
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
public class IrpAccHistServiceImpl implements IrpAccHistService {
    @Autowired
    IrpAccHistMapper irpAccHistMapper;

    @Override
    public IrpAccHistEntity regIrpAccHist(IrpAccHistForm dom) {
        irpAccHistMapper.insertIrpAccHist(dom.getEntity());
        return irpAccHistMapper.selectIrpAccHist(new IrpAccHistSearch(dom));
    }

    @Override
    public IrpAccHistEntity modIrpAccHist(IrpAccHistForm dom) {
        irpAccHistMapper.updateIrpAccHist(dom.getEntity());
        return irpAccHistMapper.selectIrpAccHist(new IrpAccHistSearch(dom));
    }

    @Override
    public void delIrpAccHist(IrpAccHistForm dom) {
        irpAccHistMapper.deleteIrpAccHist(dom.getEntity());
        return;
    }

    @Override
    public IrpAccHistEntity getIrpAccHist(IrpAccHistSearch dom) {
        return irpAccHistMapper.selectIrpAccHist(dom);
    }

    @Override
    public IrpAccHistEntity getIrpAccHistLast(IrpAccHistSearch dom) {
        return irpAccHistMapper.selectIrpAccHistLast(dom);
    }

    @Override
    public ResultListDto<IrpAccHistEntity> getIrpAccHistList(IrpAccHistSearch dom) {
        ResultListDto<IrpAccHistEntity> result = new ResultListDto<>();
        Long totalCnt = irpAccHistMapper.selectIrpAccHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<IrpAccHistEntity> list = irpAccHistMapper.selectIrpAccHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
