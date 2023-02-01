package com.kpcnc.mydataapi.api;

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
    public InvtAccProdEntity regInvtAccProd(InvtAccProdForm dom) {
        invtAccProdMapper.insertInvtAccProd(dom.getEntity());
        return invtAccProdMapper.selectInvtAccProd(new InvtAccProdSearch(dom));
    }

    @Override
    public InvtAccProdEntity modInvtAccProd(InvtAccProdForm dom) {
        invtAccProdMapper.updateInvtAccProd(dom.getEntity());
        return invtAccProdMapper.selectInvtAccProd(new InvtAccProdSearch(dom));
    }

    @Override
    public void delInvtAccProd(InvtAccProdForm dom) {
        invtAccProdMapper.deleteInvtAccProd(dom.getEntity());
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
