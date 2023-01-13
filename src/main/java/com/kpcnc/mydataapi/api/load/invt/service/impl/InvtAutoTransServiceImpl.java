package com.kpcnc.mydataapi.api.load.invt.service.impl;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAutoTransSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAutoTransEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtAutoTransForm;
import com.kpcnc.mydataapi.api.load.invt.repository.InvtAutoTransMapper;
import com.kpcnc.mydataapi.api.load.invt.service.InvtAutoTransService;
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
public class InvtAutoTransServiceImpl implements InvtAutoTransService {
    @Autowired
    InvtAutoTransMapper invtAutoTransMapper;

    @Override
    public InvtAutoTransEntity regInvtAutoTrans(InvtAutoTransForm dom) {
        invtAutoTransMapper.insertInvtAutoTrans(dom.getEntity());
        return invtAutoTransMapper.selectInvtAutoTrans(new InvtAutoTransSearch(dom));
    }

    @Override
    public InvtAutoTransEntity modInvtAutoTrans(InvtAutoTransForm dom) {
        invtAutoTransMapper.updateInvtAutoTrans(dom.getEntity());
        return invtAutoTransMapper.selectInvtAutoTrans(new InvtAutoTransSearch(dom));
    }

    @Override
    public void delInvtAutoTrans(InvtAutoTransForm dom) {
        invtAutoTransMapper.deleteInvtAutoTrans(dom.getEntity());
        return;
    }

    @Override
    public InvtAutoTransEntity getInvtAutoTrans(InvtAutoTransSearch dom) {
        return invtAutoTransMapper.selectInvtAutoTrans(dom);
    }

    @Override
    public ResultListDto<InvtAutoTransEntity> getInvtAutoTransList(InvtAutoTransSearch dom) {
        ResultListDto<InvtAutoTransEntity> result = new ResultListDto<>();
        Long totalCnt = invtAutoTransMapper.selectInvtAutoTransListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InvtAutoTransEntity> list = invtAutoTransMapper.selectInvtAutoTransList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
