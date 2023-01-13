package com.kpcnc.mydataapi.api.load.irp.service.impl;

import com.kpcnc.mydataapi.api.load.irp.models.IrpAccAddSearch;
import com.kpcnc.mydataapi.api.load.irp.models.entity.IrpAccAddEntity;
import com.kpcnc.mydataapi.api.load.irp.models.form.IrpAccAddForm;
import com.kpcnc.mydataapi.api.load.irp.repository.IrpAccAddMapper;
import com.kpcnc.mydataapi.api.load.irp.service.IrpAccAddService;
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
public class IrpAccAddServiceImpl implements IrpAccAddService {
    @Autowired
    IrpAccAddMapper irpAccAddMapper;

    @Override
    public IrpAccAddEntity regIrpAccAdd(IrpAccAddForm dom) {
        irpAccAddMapper.insertIrpAccAdd(dom.getEntity());
        return irpAccAddMapper.selectIrpAccAdd(new IrpAccAddSearch(dom));
    }

    @Override
    public IrpAccAddEntity modIrpAccAdd(IrpAccAddForm dom) {
        irpAccAddMapper.updateIrpAccAdd(dom.getEntity());
        return irpAccAddMapper.selectIrpAccAdd(new IrpAccAddSearch(dom));
    }

    @Override
    public void delIrpAccAdd(IrpAccAddForm dom) {
        irpAccAddMapper.deleteIrpAccAdd(dom.getEntity());
        return;
    }

    @Override
    public IrpAccAddEntity getIrpAccAdd(IrpAccAddSearch dom) {
        return irpAccAddMapper.selectIrpAccAdd(dom);
    }

    @Override
    public ResultListDto<IrpAccAddEntity> getIrpAccAddList(IrpAccAddSearch dom) {
        ResultListDto<IrpAccAddEntity> result = new ResultListDto<>();
        Long totalCnt = irpAccAddMapper.selectIrpAccAddListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<IrpAccAddEntity> list = irpAccAddMapper.selectIrpAccAddList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
