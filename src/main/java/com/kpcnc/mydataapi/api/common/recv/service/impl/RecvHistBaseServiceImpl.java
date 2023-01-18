package com.kpcnc.mydataapi.api.common.recv.service.impl;

import com.kpcnc.mydataapi.api.common.recv.models.RecvHistBaseSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvHistBaseEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.kpcnc.mydataapi.api.common.recv.repository.RecvHistBaseMapper;
import com.kpcnc.mydataapi.api.common.recv.service.RecvHistBaseService;
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
public class RecvHistBaseServiceImpl implements RecvHistBaseService {
    @Autowired
    RecvHistBaseMapper recvHistBaseMapper;

    @Override
    public void regRecvHistBase(RecvHistBaseForm dom) {
        recvHistBaseMapper.insertRecvHistBase(dom.getEntity());
        return;
    }

    @Override
    public void updRecvHistBase(RecvHistBaseForm dom) {
        recvHistBaseMapper.updateRecvHistBase(dom.getEntity());
        return;
    }

    @Override
    public void modRecvHistBase(RecvHistBaseForm dom) {
        if(getRecvHistBase(new RecvHistBaseSearch(dom)) == null){
            regRecvHistBase(dom);
        }else{
            updRecvHistBase(dom);
        }
        return;
    }

    @Override
    public void delRecvHistBase(RecvHistBaseForm dom) {
        recvHistBaseMapper.deleteRecvHistBase(dom.getEntity());
        return;
    }

    @Override
    public RecvHistBaseEntity getRecvHistBase(RecvHistBaseSearch dom) {
        return recvHistBaseMapper.selectRecvHistBase(dom);
    }

    @Override
    public ResultListDto<RecvHistBaseEntity> getRecvHistBaseList(RecvHistBaseSearch dom) {
        ResultListDto<RecvHistBaseEntity> result = new ResultListDto<>();
        Long totalCnt = recvHistBaseMapper.selectRecvHistBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<RecvHistBaseEntity> list = recvHistBaseMapper.selectRecvHistBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
