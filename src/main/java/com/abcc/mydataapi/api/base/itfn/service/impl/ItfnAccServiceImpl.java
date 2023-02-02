package com.abcc.mydataapi.api.base.itfn.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.itfn.models.ItfnAccSearch;
import com.abcc.mydataapi.api.base.itfn.models.entity.ItfnAccEntity;
import com.abcc.mydataapi.api.base.itfn.models.form.ItfnAccForm;
import com.abcc.mydataapi.api.base.itfn.repository.ItfnAccMapper;
import com.abcc.mydataapi.api.base.itfn.service.ItfnAccService;
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
public class ItfnAccServiceImpl implements ItfnAccService {
    @Autowired
    ItfnAccMapper itfnAccMapper;

    @Override
    public void regItfnAcc(ItfnAccForm dom) {
        itfnAccMapper.insertItfnAcc(dom.getEntity());
    }

    @Override
    public void updItfnAcc(ItfnAccForm dom) {
        itfnAccMapper.updateItfnAcc(dom.getEntity());
    }

    @Override
    public void modItfnAcc(ItfnAccForm dom) {
        if(getItfnAcc(new ItfnAccSearch(dom)) == null){
            regItfnAcc(dom);
        }else{
            updItfnAcc(dom);
        }
    }

    @Override
    public void delItfnAcc(ItfnAccForm dom) {
        itfnAccMapper.deleteItfnAcc(dom.getEntity());
        return;
    }

    @Override
    public void allDelItfnAcc(ItfnAccForm dom) {
        itfnAccMapper.deleteAllItfnAcc(dom.getEntity());
        return;
    }

    @Override
    public ItfnAccEntity getItfnAcc(ItfnAccSearch dom) {
        return itfnAccMapper.selectItfnAcc(dom);
    }

    @Override
    public ResultListDto<ItfnAccEntity> getItfnAccList(ItfnAccSearch dom) {
        ResultListDto<ItfnAccEntity> result = new ResultListDto<>();
        Long totalCnt = itfnAccMapper.selectItfnAccListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ItfnAccEntity> list = itfnAccMapper.selectItfnAccList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
