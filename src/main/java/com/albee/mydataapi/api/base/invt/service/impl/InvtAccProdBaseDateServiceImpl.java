package com.albee.mydataapi.api.base.invt.service.impl;

import com.albee.mydataapi.api.base.invt.repository.InvtAccProdBaseDateMapper;
import com.albee.mydataapi.api.base.invt.service.InvtAccProdBaseDateService;
import com.albee.mydataapi.api.base.invt.models.InvtAccProdBaseDateSearch;
import com.albee.mydataapi.api.base.invt.models.entity.InvtAccProdBaseDateEntity;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccProdBaseDateForm;
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
public class InvtAccProdBaseDateServiceImpl implements InvtAccProdBaseDateService {
    @Autowired
    InvtAccProdBaseDateMapper invtAccProdBaseDateMapper;

    @Override
    public void regInvtAccProdBaseDate(InvtAccProdBaseDateForm dom) {
        invtAccProdBaseDateMapper.insertInvtAccProdBaseDate(dom.getEntity());
    }

    @Override
    public void updInvtAccProdBaseDate(InvtAccProdBaseDateForm dom) {
        invtAccProdBaseDateMapper.updateInvtAccProdBaseDate(dom.getEntity());
    }

    @Override
    public void modInvtAccProdBaseDate(InvtAccProdBaseDateForm dom) {
        if(getInvtAccProdBaseDate(new InvtAccProdBaseDateSearch(dom)) == null){
            regInvtAccProdBaseDate(dom);
        }else{
            updInvtAccProdBaseDate(dom);
        }
    }

    @Override
    public void delInvtAccProdBaseDate(InvtAccProdBaseDateForm dom) {
        invtAccProdBaseDateMapper.deleteInvtAccProdBaseDate(dom.getEntity());
        return;
    }

    @Override
    public InvtAccProdBaseDateEntity getInvtAccProdBaseDate(InvtAccProdBaseDateSearch dom) {
        return invtAccProdBaseDateMapper.selectInvtAccProdBaseDate(dom);
    }

    @Override
    public ResultListDto<InvtAccProdBaseDateEntity> getInvtAccProdBaseDateList(InvtAccProdBaseDateSearch dom) {
        ResultListDto<InvtAccProdBaseDateEntity> result = new ResultListDto<>();
        Long totalCnt = invtAccProdBaseDateMapper.selectInvtAccProdBaseDateListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InvtAccProdBaseDateEntity> list = invtAccProdBaseDateMapper.selectInvtAccProdBaseDateList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
