package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuCarSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuCarEntity;
import com.kpcnc.mydataapi.api.load.insu.models.form.InsuCarForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuCarMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuCarService;
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
public class InsuCarServiceImpl implements InsuCarService {
    @Autowired
    InsuCarMapper insuCarMapper;

    @Override
    public InsuCarEntity regInsuCar(InsuCarForm dom) {
        insuCarMapper.insertInsuCar(dom.getEntity());
        return insuCarMapper.selectInsuCar(new InsuCarSearch(dom));
    }

    @Override
    public InsuCarEntity modInsuCar(InsuCarForm dom) {
        insuCarMapper.updateInsuCar(dom.getEntity());
        return insuCarMapper.selectInsuCar(new InsuCarSearch(dom));
    }

    @Override
    public void delInsuCar(InsuCarForm dom) {
        insuCarMapper.deleteInsuCar(dom.getEntity());
        return;
    }

    @Override
    public InsuCarEntity getInsuCar(InsuCarSearch dom) {
        return insuCarMapper.selectInsuCar(dom);
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
