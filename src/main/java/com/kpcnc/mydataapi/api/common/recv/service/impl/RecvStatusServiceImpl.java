package com.kpcnc.mydataapi.api.common.recv.service.impl;

import com.kpcnc.mydataapi.api.common.recv.models.RecvStatusSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvStatusEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.kpcnc.mydataapi.api.common.recv.repository.RecvStatusMapper;
import com.kpcnc.mydataapi.api.common.recv.service.RecvStatusService;
import com.kpcnc.mydataapi.common.CommUtil;
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
public class RecvStatusServiceImpl implements RecvStatusService {
    @Autowired
    RecvStatusMapper recvStatusMapper;

    @Override
    public String createRecvSeq(RecvStatusForm dom){
        return recvStatusMapper.createRecvSeq(dom.getEntity());
    }

    @Override
    public RecvStatusEntity regRecvStatus(RecvStatusForm dom) {
        recvStatusMapper.insertRecvStatus(dom.getEntity());
        return recvStatusMapper.selectRecvStatus(new RecvStatusSearch(dom));
    }

    @Override
    public RecvStatusEntity updRecvStatus(RecvStatusForm dom) {
        RecvStatusEntity entity = getRecvStatus(new RecvStatusSearch(dom));
        entity.setCompleteOrgCnt(entity.getCompleteOrgCnt() + dom.getIncOrgCnt());
        entity.setLastRecvDt(CommUtil.getCurrentDateTime14());
        entity.setLastRecvOrgCd(dom.getLastRecvOrgCd());
        entity.setChgUserId("user01");
        recvStatusMapper.updateRecvStatus(dom.getEntity());
        return recvStatusMapper.selectRecvStatus(new RecvStatusSearch(dom));
    }

    @Override
    public RecvStatusEntity modRecvStatus(RecvStatusForm dom) {
        if(getRecvStatus(new RecvStatusSearch(dom)) == null){
            regRecvStatus(dom);
        }else{
            updRecvStatus(dom);
        }
        return recvStatusMapper.selectRecvStatus(new RecvStatusSearch(dom));
    }

    @Override
    public void delRecvStatus(RecvStatusForm dom) {
        recvStatusMapper.deleteRecvStatus(dom.getEntity());
        return;
    }

    @Override
    public RecvStatusEntity getRecvStatus(RecvStatusSearch dom) {
        return recvStatusMapper.selectRecvStatus(dom);
    }

    @Override
    public ResultListDto<RecvStatusEntity> getRecvStatusList(RecvStatusSearch dom) {
        ResultListDto<RecvStatusEntity> result = new ResultListDto<>();
        Long totalCnt = recvStatusMapper.selectRecvStatusListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<RecvStatusEntity> list = recvStatusMapper.selectRecvStatusList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
