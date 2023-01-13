package com.kpcnc.mydataapi.api.load.invt.service.impl;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAccHistSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccHistEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtAccHistForm;
import com.kpcnc.mydataapi.api.load.invt.repository.InvtAccHistMapper;
import com.kpcnc.mydataapi.api.load.invt.service.InvtAccHistService;
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
public class InvtAccHistServiceImpl implements InvtAccHistService {
    @Autowired
    InvtAccHistMapper invtAccHistMapper;

    @Override
    public InvtAccHistEntity regInvtAccHist(InvtAccHistForm dom) {
        invtAccHistMapper.insertInvtAccHist(dom.getEntity());
        return invtAccHistMapper.selectInvtAccHist(new InvtAccHistSearch(dom));
    }

    @Override
    public InvtAccHistEntity modInvtAccHist(InvtAccHistForm dom) {
        invtAccHistMapper.updateInvtAccHist(dom.getEntity());
        return invtAccHistMapper.selectInvtAccHist(new InvtAccHistSearch(dom));
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
