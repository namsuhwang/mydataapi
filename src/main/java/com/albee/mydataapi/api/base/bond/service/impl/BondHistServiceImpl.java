package com.albee.mydataapi.api.base.bond.service.impl;

import com.albee.mydataapi.api.base.bond.models.BondHistSearch;
import com.albee.mydataapi.api.base.bond.models.entity.BondHistEntity;
import com.albee.mydataapi.api.base.bond.service.BondHistService;
import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.bond.models.form.BondHistForm;
import com.albee.mydataapi.api.base.bond.repository.BondHistMapper;
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
public class BondHistServiceImpl implements BondHistService {
    @Autowired
    BondHistMapper bondHistMapper;

    @Override
    public BondHistEntity regBondHist(BondHistForm dom) {
        bondHistMapper.insertBondHist(dom.getEntity());
        return bondHistMapper.selectBondHist(new BondHistSearch(dom));
    }

    @Override
    public BondHistEntity modBondHist(BondHistForm dom) {
        bondHistMapper.updateBondHist(dom.getEntity());
        return bondHistMapper.selectBondHist(new BondHistSearch(dom));
    }

    @Override
    public void delBondHist(BondHistForm dom) {
        bondHistMapper.deleteBondHist(dom.getEntity());
        return;
    }

    @Override
    public BondHistEntity getBondHist(BondHistSearch dom) {
        return bondHistMapper.selectBondHist(dom);
    }


    @Override
    public BondHistEntity getBondHistLast(BondHistSearch dom) {
        return bondHistMapper.selectBondHistLast(dom);
    }


    @Override
    public ResultListDto<BondHistEntity> getBondHistList(BondHistSearch dom) {
        ResultListDto<BondHistEntity> result = new ResultListDto<>();
        Long totalCnt = bondHistMapper.selectBondHistListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<BondHistEntity> list = bondHistMapper.selectBondHistList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
