package com.abcc.mydataapi.api.base.invt.service.impl;

import com.abcc.mydataapi.api.base.invt.models.InvtAccSearch;
import com.abcc.mydataapi.api.base.invt.models.entity.InvtAccEntity;
import com.abcc.mydataapi.api.base.invt.models.form.InvtAccForm;
import com.abcc.mydataapi.api.base.invt.repository.InvtAccMapper;
import com.abcc.mydataapi.api.base.invt.service.InvtAccService;
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
public class InvtAccServiceImpl implements InvtAccService {
    @Autowired
    InvtAccMapper invtAccMapper;

    @Override
    public void regInvtAcc(InvtAccForm dom) {
        invtAccMapper.insertInvtAcc(dom.getEntity());
    }

    @Override
    public void updInvtAcc(InvtAccForm dom) {
        invtAccMapper.updateInvtAcc(dom.getEntity());
    }

    @Override
    public void modInvtAcc(InvtAccForm dom) {
        if(getInvtAcc(new InvtAccSearch(dom)) == null){
            regInvtAcc(dom);
        }else{
            updInvtAcc(dom);
        }
    }

    @Override
    public void delInvtAcc(InvtAccForm dom) {
        invtAccMapper.deleteInvtAcc(dom.getEntity());
        return;
    }

    @Override
    public void allDelInvtAcc(InvtAccForm dom) {
        invtAccMapper.deleteAllInvtAcc(dom.getEntity());
        return;
    }

    @Override
    public InvtAccEntity getInvtAcc(InvtAccSearch dom) {
        return invtAccMapper.selectInvtAcc(dom);
    }

    @Override
    public ResultListDto<InvtAccEntity> getInvtAccList(InvtAccSearch dom) {
        ResultListDto<InvtAccEntity> result = new ResultListDto<>();
        Long totalCnt = invtAccMapper.selectInvtAccListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InvtAccEntity> list = invtAccMapper.selectInvtAccList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
