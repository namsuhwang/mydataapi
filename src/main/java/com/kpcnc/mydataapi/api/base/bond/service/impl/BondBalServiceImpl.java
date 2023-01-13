package com.kpcnc.mydataapi.api.base.bond.service.impl;

import com.kpcnc.mydataapi.api.base.bond.models.BondBalSearch;
import com.kpcnc.mydataapi.api.base.bond.models.entity.BondBalEntity;
import com.kpcnc.mydataapi.api.base.bond.models.form.BondBalForm;
import com.kpcnc.mydataapi.api.base.bond.repository.BondBalMapper;
import com.kpcnc.mydataapi.api.base.bond.service.BondBalService;
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
public class BondBalServiceImpl implements BondBalService {
    @Autowired
    BondBalMapper bondBalMapper;

    @Override
    public BondBalEntity regBondBal(BondBalForm dom) {
        bondBalMapper.insertBondBal(dom.getEntity());
        return bondBalMapper.selectBondBal(new BondBalSearch(dom));
    }

    @Override
    public BondBalEntity modBondBal(BondBalForm dom) {
        bondBalMapper.updateBondBal(dom.getEntity());
        return bondBalMapper.selectBondBal(new BondBalSearch(dom));
    }

    @Override
    public void delBondBal(BondBalForm dom) {
        bondBalMapper.deleteBondBal(dom.getEntity());
        return;
    }

    @Override
    public BondBalEntity getBondBal(BondBalSearch dom) {
        return bondBalMapper.selectBondBal(dom);
    }

    @Override
    public ResultListDto<BondBalEntity> getBondBalList(BondBalSearch dom) {
        ResultListDto<BondBalEntity> result = new ResultListDto<>();
        Long totalCnt = bondBalMapper.selectBondBalListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BondBalEntity> list = bondBalMapper.selectBondBalList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
