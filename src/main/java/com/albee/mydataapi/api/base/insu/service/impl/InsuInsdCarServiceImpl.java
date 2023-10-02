package com.albee.mydataapi.api.base.insu.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.insu.models.InsuInsdCarSearch;
import com.albee.mydataapi.api.base.insu.models.entity.InsuInsdCarEntity;
import com.albee.mydataapi.api.base.insu.models.form.InsuInsdCarForm;
import com.albee.mydataapi.api.base.insu.repository.InsuInsdCarMapper;
import com.albee.mydataapi.api.base.insu.service.InsuInsdCarService;
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
public class InsuInsdCarServiceImpl implements InsuInsdCarService {
    @Autowired
    InsuInsdCarMapper insuInsdCarMapper;

    @Override
    public void regInsuInsdCar(InsuInsdCarForm dom) {
        insuInsdCarMapper.insertInsuInsdCar(dom.getEntity());
    }

    @Override
    public void updInsuInsdCar(InsuInsdCarForm dom) {
        insuInsdCarMapper.updateInsuInsdCar(dom.getEntity());
    }

    @Override
    public void modInsuInsdCar(InsuInsdCarForm dom) {
        if(getInsuInsdCar(new InsuInsdCarSearch(dom)) == null){
            regInsuInsdCar(dom);
        }else{
            updInsuInsdCar(dom);
        }
    }

    @Override
    public void delInsuInsdCar(InsuInsdCarForm dom) {
        insuInsdCarMapper.deleteInsuInsdCar(dom.getEntity());
        return;
    }

    @Override
    public void allDelInsuInsdCar(InsuInsdCarForm dom) {
        insuInsdCarMapper.deleteAllInsuInsdCar(dom.getEntity());
        return;
    }

    @Override
    public InsuInsdCarEntity getInsuInsdCar(InsuInsdCarSearch dom) {
        return insuInsdCarMapper.selectInsuInsdCar(dom);
    }

    @Override
    public InsuInsdCarEntity getInsuInsdCarLast(InsuInsdCarSearch dom) {
        return insuInsdCarMapper.selectInsuInsdCarLast(dom);
    }

    @Override
    public ResultListDto<InsuInsdCarEntity> getInsuInsdCarList(InsuInsdCarSearch dom) {
        ResultListDto<InsuInsdCarEntity> result = new ResultListDto<>();
        Long totalCnt = insuInsdCarMapper.selectInsuInsdCarListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuInsdCarEntity> list = insuInsdCarMapper.selectInsuInsdCarList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
