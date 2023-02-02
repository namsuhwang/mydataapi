package com.abcc.mydataapi.api.base.insu.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.insu.models.InsuCarSearch;
import com.abcc.mydataapi.api.base.insu.models.entity.InsuCarEntity;
import com.abcc.mydataapi.api.base.insu.models.form.InsuCarForm;
import com.abcc.mydataapi.api.base.insu.repository.InsuCarMapper;
import com.abcc.mydataapi.api.base.insu.service.InsuCarService;
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
public class InsuCarServiceImpl implements InsuCarService {
    @Autowired
    InsuCarMapper insuCarMapper;

    @Override
    public void regInsuCar(InsuCarForm dom) {
        insuCarMapper.insertInsuCar(dom.getEntity());
    }

    @Override
    public void updInsuCar(InsuCarForm dom) {
        insuCarMapper.updateInsuCar(dom.getEntity());
    }

    @Override
    public void modInsuCar(InsuCarForm dom) {
        if(getInsuCar(new InsuCarSearch(dom)) == null){
            regInsuCar(dom);
        }else{
            updInsuCar(dom);
        }
    }

    @Override
    public void delInsuCar(InsuCarForm dom) {
        insuCarMapper.deleteInsuCar(dom.getEntity());
        return;
    }

    @Override
    public void allDelInsuCar(InsuCarForm dom) {
        insuCarMapper.deleteAllInsuCar(dom.getEntity());
    }

    @Override
    public InsuCarEntity getInsuCar(InsuCarSearch dom) {
        return insuCarMapper.selectInsuCar(dom);
    }

    @Override
    public InsuCarEntity getInsuCarLast(InsuCarSearch dom) {
        return insuCarMapper.selectInsuCarLast(dom);
    }

    @Override
    public ResultListDto<InsuCarEntity> getInsuCarList(InsuCarSearch dom) {
        ResultListDto<InsuCarEntity> result = new ResultListDto<>();
        Long totalCnt = insuCarMapper.selectInsuCarListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuCarEntity> list = insuCarMapper.selectInsuCarList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
