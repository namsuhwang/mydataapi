package com.kpcnc.mydataapi.api.common.recv.service.impl;

import com.kpcnc.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvBaselineForm;
import com.kpcnc.mydataapi.api.common.recv.repository.RecvBaselineMapper;
import com.kpcnc.mydataapi.api.common.recv.service.RecvBaselineService;
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
public class RecvBaselineServiceImpl implements RecvBaselineService {
    @Autowired
    RecvBaselineMapper recvBaselineMapper;

    @Override
    public void regRecvBaseline(RecvBaselineForm dom) {
        recvBaselineMapper.insertRecvBaseline(dom.getEntity());
        return;
    }


    @Override
    public void updRecvBaseline(RecvBaselineForm dom) {
        recvBaselineMapper.updateRecvBaseline(dom.getEntity());
        return;
    }

    @Override
    public void modRecvBaseline(RecvBaselineForm dom) {
        if(getRecvBaseline(new RecvBaselineSearch(dom)) == null){
            regRecvBaseline(dom);
        }else{
            updRecvBaseline(dom);
        }
        return;
    }

    @Override
    public void delRecvBaseline(RecvBaselineForm dom) {
        recvBaselineMapper.deleteRecvBaseline(dom.getEntity());
        return;
    }

    @Override
    public RecvBaselineEntity getRecvBaseline(RecvBaselineSearch dom) {
        return recvBaselineMapper.selectRecvBaseline(dom);
    }

    @Override
    public ResultListDto<RecvBaselineEntity> getRecvBaselineList(RecvBaselineSearch dom) {
        ResultListDto<RecvBaselineEntity> result = new ResultListDto<>();
        Long totalCnt = recvBaselineMapper.selectRecvBaselineListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<RecvBaselineEntity> list = recvBaselineMapper.selectRecvBaselineList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
