package com.abcc.mydataapi.api.base.irp.service.impl;

import com.abcc.mydataapi.api.base.irp.models.IrpAccAddSearch;
import com.abcc.mydataapi.api.base.irp.models.form.IrpAccAddForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.irp.models.entity.IrpAccAddEntity;
import com.abcc.mydataapi.api.base.irp.repository.IrpAccAddMapper;
import com.abcc.mydataapi.api.base.irp.service.IrpAccAddService;
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
    public void regIrpAccAdd(IrpAccAddForm dom) {
        irpAccAddMapper.insertIrpAccAdd(dom.getEntity());
    }

    @Override
    public void updIrpAccAdd(IrpAccAddForm dom) {
        irpAccAddMapper.updateIrpAccAdd(dom.getEntity());
    }

    @Override
    public void modIrpAccAdd(IrpAccAddForm dom) {
        if(getIrpAccAdd(new IrpAccAddSearch(dom)) == null){
            regIrpAccAdd(dom);
        }else{
            updIrpAccAdd(dom);
        }
    }

    @Override
    public void delIrpAccAdd(IrpAccAddForm dom) {
        irpAccAddMapper.deleteIrpAccAdd(dom.getEntity());
    }

    @Override
    public void allDelIrpAccAdd(IrpAccAddForm dom) {
        irpAccAddMapper.deleteAllIrpAccAdd(dom.getEntity());
    }
    @Override
    public IrpAccAddEntity getIrpAccAdd(IrpAccAddSearch dom) {
        return irpAccAddMapper.selectIrpAccAdd(dom);
    }


    @Override
    public IrpAccAddEntity getIrpAccAddLast(IrpAccAddSearch dom) {
        return irpAccAddMapper.selectIrpAccAddLast(dom);
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
