package com.albee.mydataapi.api.base.invt.service.impl;

import com.albee.mydataapi.api.base.invt.models.InvtPensionAccAddSearch;
import com.albee.mydataapi.api.base.invt.models.entity.InvtPensionAccAddEntity;
import com.albee.mydataapi.api.base.invt.models.form.InvtPensionAccAddForm;
import com.albee.mydataapi.api.base.invt.repository.InvtPensionAccAddMapper;
import com.albee.mydataapi.api.base.invt.service.InvtPensionAccAddService;
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
public class InvtPensionAccAddServiceImpl implements InvtPensionAccAddService {
    @Autowired
    InvtPensionAccAddMapper invtPensionAccAddMapper;

    @Override
    public void regInvtPensionAccAdd(InvtPensionAccAddForm dom) {
        invtPensionAccAddMapper.insertInvtPensionAccAdd(dom.getEntity());
    }

    @Override
    public void updInvtPensionAccAdd(InvtPensionAccAddForm dom) {
        invtPensionAccAddMapper.updateInvtPensionAccAdd(dom.getEntity());
    }

    @Override
    public void modInvtPensionAccAdd(InvtPensionAccAddForm dom) {
        if(getInvtPensionAccAdd(new InvtPensionAccAddSearch(dom)) == null){
            regInvtPensionAccAdd(dom);
        }else{
            updInvtPensionAccAdd(dom);
        }
    }

    @Override
    public void delInvtPensionAccAdd(InvtPensionAccAddForm dom) {
        invtPensionAccAddMapper.deleteInvtPensionAccAdd(dom.getEntity());
        return;
    }

    @Override
    public InvtPensionAccAddEntity getInvtPensionAccAdd(InvtPensionAccAddSearch dom) {
        return invtPensionAccAddMapper.selectInvtPensionAccAdd(dom);
    }

    @Override
    public ResultListDto<InvtPensionAccAddEntity> getInvtPensionAccAddList(InvtPensionAccAddSearch dom) {
        ResultListDto<InvtPensionAccAddEntity> result = new ResultListDto<>();
        Long totalCnt = invtPensionAccAddMapper.selectInvtPensionAccAddListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InvtPensionAccAddEntity> list = invtPensionAccAddMapper.selectInvtPensionAccAddList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
