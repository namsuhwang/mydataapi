package com.kpcnc.mydataapi.api.common.recv.service.impl;

import com.kpcnc.mydataapi.api.common.recv.models.RecvHistDetailSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvHistDetailEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistDetailForm;
import com.kpcnc.mydataapi.api.common.recv.repository.RecvHistDetailMapper;
import com.kpcnc.mydataapi.api.common.recv.service.RecvHistDetailService;
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
public class RecvHistDetailServiceImpl implements RecvHistDetailService {
    @Autowired
    RecvHistDetailMapper recvHistDetailMapper;

    @Override
    public Long createRecvDetailSeq(){
        return recvHistDetailMapper.createRecvDetailSeq();
    }

    @Override
    public void regRecvHistDetail(RecvHistBaseForm recvHistBaseForm, String resultJson){
        RecvHistDetailForm regHistDetailFrom = new RecvHistDetailForm(recvHistBaseForm);
        regHistDetailFrom.setRecvData(resultJson);
        regRecvHistDetail(regHistDetailFrom);
        return;
    }

    @Override
    public void regRecvHistDetail(RecvHistDetailForm dom) {
        recvHistDetailMapper.insertRecvHistDetail(dom.getEntity());
        return;
    }

    @Override
    public void updRecvHistDetail(RecvHistDetailForm dom) {
        recvHistDetailMapper.updateRecvHistDetail(dom.getEntity());
        return;
    }

    @Override
    public void modRecvHistDetail(RecvHistDetailForm dom) {
        if(getRecvHistDetail(new RecvHistDetailSearch(dom)) == null){
            regRecvHistDetail(dom);
        }else{
            updRecvHistDetail(dom);
        }
        return;
    }

    @Override
    public void delRecvHistDetail(RecvHistDetailForm dom) {
        recvHistDetailMapper.deleteRecvHistDetail(dom.getEntity());
        return;
    }

    @Override
    public RecvHistDetailEntity getRecvHistDetail(RecvHistDetailSearch dom) {
        return recvHistDetailMapper.selectRecvHistDetail(dom);
    }

    @Override
    public ResultListDto<RecvHistDetailEntity> getRecvHistDetailList(RecvHistDetailSearch dom) {
        ResultListDto<RecvHistDetailEntity> result = new ResultListDto<>();
        Long totalCnt = recvHistDetailMapper.selectRecvHistDetailListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<RecvHistDetailEntity> list = recvHistDetailMapper.selectRecvHistDetailList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
