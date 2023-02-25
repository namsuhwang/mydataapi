package com.albee.mydataapi.api.common.trans.service.impl;

import com.albee.mydataapi.api.common.trans.models.TransReqSearch;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;
import com.albee.mydataapi.api.common.trans.models.form.TransReqForm;
import com.albee.mydataapi.api.common.trans.repository.TransReqMapper;
import com.albee.mydataapi.api.common.trans.service.TransReqDbService;
import com.albee.mydataapi.common.models.dto.ResultListDto;
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
public class TransReqDbServiceImpl implements TransReqDbService {
    @Autowired
    TransReqMapper transReqMapper;

    @Override
    public void regTransReq(TransReqForm dom) {
        transReqMapper.insertTransReq(dom.getEntity());
    }

    @Override
    public void updTransReq(TransReqForm dom) {
        transReqMapper.updateTransReq(dom.getEntity());
    }

    @Override
    public void modTransReq(TransReqForm dom) {
        if(getTransReq(new TransReqSearch(dom)) == null){
            regTransReq(dom);
        }else{
            updTransReq(dom);
        }
    }

    @Override
    public void delTransReq(TransReqForm dom) {
        transReqMapper.deleteTransReq(dom.getEntity());
    }

    @Override
    public TransReqEntity getTransReq(TransReqSearch dom) {
        return transReqMapper.selectTransReq(dom);
    }

    @Override
    public ResultListDto<TransReqEntity> getTransReqList(TransReqSearch dom) {
        ResultListDto<TransReqEntity> result = new ResultListDto<>();
        Long totalCnt = transReqMapper.selectTransReqListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<TransReqEntity> list = transReqMapper.selectTransReqList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
