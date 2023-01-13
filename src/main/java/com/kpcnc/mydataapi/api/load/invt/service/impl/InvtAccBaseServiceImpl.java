package com.kpcnc.mydataapi.api.load.invt.service.impl;

import com.kpcnc.mydataapi.api.load.invt.models.InvtAccBaseSearch;
import com.kpcnc.mydataapi.api.load.invt.models.entity.InvtAccBaseEntity;
import com.kpcnc.mydataapi.api.load.invt.models.form.InvtAccBaseForm;
import com.kpcnc.mydataapi.api.load.invt.repository.InvtAccBaseMapper;
import com.kpcnc.mydataapi.api.load.invt.service.InvtAccBaseService;
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
public class InvtAccBaseServiceImpl implements InvtAccBaseService {
    @Autowired
    InvtAccBaseMapper invtAccBaseMapper;

    @Override
    public InvtAccBaseEntity regInvtAccBase(InvtAccBaseForm dom) {
        invtAccBaseMapper.insertInvtAccBase(dom.getEntity());
        return invtAccBaseMapper.selectInvtAccBase(new InvtAccBaseSearch(dom));
    }

    @Override
    public InvtAccBaseEntity modInvtAccBase(InvtAccBaseForm dom) {
        invtAccBaseMapper.updateInvtAccBase(dom.getEntity());
        return invtAccBaseMapper.selectInvtAccBase(new InvtAccBaseSearch(dom));
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
