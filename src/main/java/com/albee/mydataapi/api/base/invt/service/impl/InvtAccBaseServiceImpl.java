package com.albee.mydataapi.api.base.invt.service.impl;

import com.albee.mydataapi.api.base.invt.models.entity.InvtAccBaseEntity;
import com.albee.mydataapi.api.base.invt.models.InvtAccBaseSearch;
import com.albee.mydataapi.api.base.invt.models.form.InvtAccBaseForm;
import com.albee.mydataapi.api.base.invt.repository.InvtAccBaseMapper;
import com.albee.mydataapi.api.base.invt.service.InvtAccBaseService;
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
public class InvtAccBaseServiceImpl implements InvtAccBaseService {
    @Autowired
    InvtAccBaseMapper invtAccBaseMapper;

    @Override
    public void regInvtAccBase(InvtAccBaseForm dom) {
        invtAccBaseMapper.insertInvtAccBase(dom.getEntity());
    }

    @Override
    public void updInvtAccBase(InvtAccBaseForm dom) {
        invtAccBaseMapper.updateInvtAccBase(dom.getEntity());
    }

    @Override
    public void modInvtAccBase(InvtAccBaseForm dom) {
        if(getInvtAccBase(new InvtAccBaseSearch(dom)) == null){
            regInvtAccBase(dom);
        }else{
            updInvtAccBase(dom);
        }
    }

    @Override
    public void delInvtAccBase(InvtAccBaseForm dom) {
        invtAccBaseMapper.deleteInvtAccBase(dom.getEntity());
        return;
    }

    @Override
    public InvtAccBaseEntity getInvtAccBase(InvtAccBaseSearch dom) {
        return invtAccBaseMapper.selectInvtAccBase(dom);
    }

    @Override
    public ResultListDto<InvtAccBaseEntity> getInvtAccBaseList(InvtAccBaseSearch dom) {
        ResultListDto<InvtAccBaseEntity> result = new ResultListDto<>();
        Long totalCnt = invtAccBaseMapper.selectInvtAccBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<InvtAccBaseEntity> list = invtAccBaseMapper.selectInvtAccBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
