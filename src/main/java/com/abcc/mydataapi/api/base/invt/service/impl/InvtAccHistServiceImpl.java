package com.abcc.mydataapi.api.base.invt.service.impl;

import com.abcc.mydataapi.api.base.invt.models.InvtAccHistSearch;
import com.abcc.mydataapi.api.base.invt.models.entity.InvtAccHistEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAccHistForm;
import com.abcc.mydataapi.api.base.invt.repository.InvtAccHistMapper;
import com.abcc.mydataapi.api.base.invt.service.InvtAccHistService;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
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
public class InvtAccHistServiceImpl implements InvtAccHistService {
    @Autowired
    InvtAccHistMapper invtAccHistMapper;

    @Override
    public void regInvtAccHist(InvtAccHistForm dom) {
        invtAccHistMapper.insertInvtAccHist(dom.getEntity());
    }

    @Override
    public void updInvtAccHist(InvtAccHistForm dom) {
        invtAccHistMapper.updateInvtAccHist(dom.getEntity());
    }

    @Override
    public void modInvtAccHist(InvtAccHistForm dom) {
        if(getInvtAccHist(new InvtAccHistSearch(dom)) == null){
            regInvtAccHist(dom);
        }else{
            updInvtAccHist(dom);
        }
    }

    @Override
    public void delInvtAccHist(InvtAccHistForm dom) {
        invtAccHistMapper.deleteInvtAccHist(dom.getEntity());
        return;
    }

    @Override
    public InvtAccHistEntity getInvtAccHist(InvtAccHistSearch dom) {
        return invtAccHistMapper.selectInvtAccHist(dom);
    }

    @Override
    public InvtAccHistEntity getInvtAccHistLast(InvtAccHistSearch dom) {
        return invtAccHistMapper.selectInvtAccHist(dom);
    }

    @Override
    public ResultListDto<InvtAccHistEntity> getInvtAccHistList(InvtAccHistSearch dom) {
        ResultListDto<InvtAccHistEntity> result = new ResultListDto<>();
        Long totalCnt = invtAccHistMapper.selectInvtAccHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InvtAccHistEntity> list = invtAccHistMapper.selectInvtAccHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
