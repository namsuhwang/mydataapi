package com.kpcnc.mydataapi.api.base.insu.service.impl;

import com.kpcnc.mydataapi.api.base.insu.models.InsuSearch;
import com.kpcnc.mydataapi.api.base.insu.models.entity.InsuEntity;
import com.kpcnc.mydataapi.api.base.insu.models.form.InsuForm;
import com.kpcnc.mydataapi.api.base.insu.repository.InsuMapper;
import com.kpcnc.mydataapi.api.base.insu.service.InsuService;
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
    public void regInsu(InsuForm dom) {
        insuMapper.insertInsu(dom.getEntity());
    }

    @Override
    public void updInsu(InsuForm dom) {
        insuMapper.updateInsu(dom.getEntity());
    }

    @Override
    public void modInsu(InsuForm dom) {
        if(getInsu(new InsuSearch(dom)) == null){
            regInsu(dom);
        }else{
            updInsu(dom);
        }
    }

    @Override
    public void delInsu(InsuForm dom) {
        insuMapper.deleteInsu(dom.getEntity());
    }

    @Override
    public void allDelInsu(InsuForm dom) {
        insuMapper.deleteAllInsu(dom.getEntity());
    }

    @Override
    public InsuEntity getInsu(InsuSearch dom) {
        return insuMapper.selectInsu(dom);
    }

    @Override
    public InsuEntity getInsuLast(InsuSearch dom) {
        return insuMapper.selectInsuLast(dom);
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
