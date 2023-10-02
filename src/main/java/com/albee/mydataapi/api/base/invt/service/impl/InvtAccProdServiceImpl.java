package com.albee.mydataapi.api.base.invt.service.impl;

import com.albee.mydataapi.api.base.invt.models.entity.InvtAccProdEntity;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccProdForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.invt.models.InvtAccProdSearch;
import com.albee.mydataapi.api.base.invt.repository.InvtAccProdMapper;
import com.albee.mydataapi.api.base.invt.service.InvtAccProdService;
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
public class InvtAccProdServiceImpl implements InvtAccProdService {
    @Autowired
    InvtAccProdMapper invtAccProdMapper;

    @Override
    public void regInvtAccProd(InvtAccProdForm dom) {
        invtAccProdMapper.insertInvtAccProd(dom.getEntity());
    }

    @Override
    public void updInvtAccProd(InvtAccProdForm dom) {
        invtAccProdMapper.updateInvtAccProd(dom.getEntity());
    }

    @Override
    public void modInvtAccProd(InvtAccProdForm dom) {
        if(getInvtAccProd(new InvtAccProdSearch(dom)) == null){
            regInvtAccProd(dom);
        }else{
            updInvtAccProd(dom);
        }
    }

    @Override
    public void delInvtAccProd(InvtAccProdForm dom) {
        invtAccProdMapper.deleteInvtAccProd(dom.getEntity());
        return;
    }

    @Override
    public void allDelInvtAccProd(InvtAccProdForm dom) {
        invtAccProdMapper.deleteAllInvtAccProd(dom.getEntity());
        return;
    }

    @Override
    public InvtAccProdEntity getInvtAccProd(InvtAccProdSearch dom) {
        return invtAccProdMapper.selectInvtAccProd(dom);
    }

    @Override
    public ResultListDto<InvtAccProdEntity> getInvtAccProdList(InvtAccProdSearch dom) {
        ResultListDto<InvtAccProdEntity> result = new ResultListDto<>();
        Long totalCnt = invtAccProdMapper.selectInvtAccProdListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InvtAccProdEntity> list = invtAccProdMapper.selectInvtAccProdList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
