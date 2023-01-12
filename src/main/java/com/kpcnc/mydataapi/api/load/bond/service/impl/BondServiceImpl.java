package com.kpcnc.mydataapi.api.load.bond.service.impl;

import com.kpcnc.mydataapi.api.load.bond.models.BondSearch;
import com.kpcnc.mydataapi.api.load.bond.models.entity.BondEntity;
import com.kpcnc.mydataapi.api.load.bond.models.form.BondForm;
import com.kpcnc.mydataapi.api.load.bond.repository.BondMapper;
import com.kpcnc.mydataapi.api.load.bond.service.BondService;
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
