package com.kpcnc.mydataapi.api.load.invt.service.impl;

import com.kpcnc.mydataapi.api.load.invt.models.InvtPensionAccAddSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtPensionAccAddEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtPensionAccAddForm;
import com.kpcnc.mydataapi.api.load.invt.repository.InvtPensionAccAddMapper;
import com.kpcnc.mydataapi.api.load.invt.service.InvtPensionAccAddService;
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
public class InvtPensionAccAddServiceImpl implements InvtPensionAccAddService {
    @Autowired
    InvtPensionAccAddMapper invtPensionAccAddMapper;

    @Override
    public InvtPensionAccAddEntity regInvtPensionAccAdd(InvtPensionAccAddForm dom) {
        invtPensionAccAddMapper.insertInvtPensionAccAdd(dom.getEntity());
        return invtPensionAccAddMapper.selectInvtPensionAccAdd(new InvtPensionAccAddSearch(dom));
    }

    @Override
    public InvtPensionAccAddEntity modInvtPensionAccAdd(InvtPensionAccAddForm dom) {
        invtPensionAccAddMapper.updateInvtPensionAccAdd(dom.getEntity());
        return invtPensionAccAddMapper.selectInvtPensionAccAdd(new InvtPensionAccAddSearch(dom));
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
