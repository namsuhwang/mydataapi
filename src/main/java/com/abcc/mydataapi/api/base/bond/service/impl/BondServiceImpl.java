package com.abcc.mydataapi.api.base.bond.service.impl;

import com.abcc.mydataapi.api.base.bond.models.BondSearch;
import com.abcc.mydataapi.api.base.bond.service.BondService;
import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.bond.models.entity.BondEntity;
import com.abcc.mydataapi.api.base.bond.models.form.BondForm;
import com.abcc.mydataapi.api.base.bond.repository.BondMapper;
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
public class BondServiceImpl implements BondService {
    @Autowired
    BondMapper bondMapper;

    @Override
    public BondEntity regBond(BondForm dom) {
        bondMapper.insertBond(dom.getEntity());
        return bondMapper.selectBond(new BondSearch(dom));
    }

    @Override
    public BondEntity modBond(BondForm dom) {
        bondMapper.updateBond(dom.getEntity());
        return bondMapper.selectBond(new BondSearch(dom));
    }

    @Override
    public void delBond(BondForm dom) {
        bondMapper.deleteBond(dom.getEntity());
        return;
    }

    @Override
    public void allDelBond(BondForm dom) {
        bondMapper.deleteAllBond(dom.getEntity());
        return;
    }


    @Override
    public BondEntity getBond(BondSearch dom) {
        return bondMapper.selectBond(dom);
    }

    @Override
    public ResultListDto<BondEntity> getBondList(BondSearch dom) {
        ResultListDto<BondEntity> result = new ResultListDto<>();
        Long totalCnt = bondMapper.selectBondListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BondEntity> list = bondMapper.selectBondList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
