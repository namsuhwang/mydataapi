package com.kpcnc.mydataapi.api.load.insu.service.impl;

import com.kpcnc.mydataapi.api.load.insu.models.InsuSearch;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuEntity;
import com.kpcnc.mydataapi.api.load.insu.models.entity.InsuForm;
import com.kpcnc.mydataapi.api.load.insu.repository.InsuMapper;
import com.kpcnc.mydataapi.api.load.insu.service.InsuService;
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
public class InsuServiceImpl implements InsuService {
    @Autowired
    InsuMapper insuMapper;

    @Override
    public InsuEntity regInsu(InsuForm dom) {
        insuMapper.insertInsu(dom.getEntity());
        return insuMapper.selectInsu(new InsuSearch(dom));
    }

    @Override
    public InsuEntity modInsu(InsuForm dom) {
        insuMapper.updateInsu(dom.getEntity());
        return insuMapper.selectInsu(new InsuSearch(dom));
    }

    @Override
    public void delInsu(InsuForm dom) {
        insuMapper.deleteInsu(dom.getEntity());
        return;
    }

    @Override
    public InsuEntity getInsu(InsuSearch dom) {
        return insuMapper.selectInsu(dom);
    }

    @Override
    public ResultListDto<InsuEntity> getInsuList(InsuSearch dom) {
        ResultListDto<InsuEntity> result = new ResultListDto<>();
        Long totalCnt = insuMapper.selectInsuListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InsuEntity> list = insuMapper.selectInsuList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
