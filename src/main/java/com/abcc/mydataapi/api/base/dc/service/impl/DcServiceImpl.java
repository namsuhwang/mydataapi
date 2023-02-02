package com.abcc.mydataapi.api.base.dc.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.dc.models.DcSearch;
import com.abcc.mydataapi.api.base.dc.models.entity.DcEntity;
import com.abcc.mydataapi.api.base.dc.models.form.DcForm;
import com.abcc.mydataapi.api.base.dc.repository.DcMapper;
import com.abcc.mydataapi.api.base.dc.service.DcService;
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
public class DcServiceImpl implements DcService {
    @Autowired
    DcMapper dcMapper;

    @Override
    public DcEntity regDc(DcForm dom) {
        dcMapper.insertDc(dom.getEntity());
        return dcMapper.selectDc(new DcSearch(dom));
    }

    @Override
    public DcEntity modDc(DcForm dom) {
        dcMapper.updateDc(dom.getEntity());
        return dcMapper.selectDc(new DcSearch(dom));
    }

    @Override
    public void delDc(DcForm dom) {
        dcMapper.deleteDc(dom.getEntity());
        return;
    }

    @Override
    public void allDelDc(DcForm dom) {
        dcMapper.deleteAllDc(dom.getEntity());
        return;
    }

    @Override
    public DcEntity getDc(DcSearch dom) {
        return dcMapper.selectDc(dom);
    }

    @Override
    public ResultListDto<DcEntity> getDcList(DcSearch dom) {
        ResultListDto<DcEntity> result = new ResultListDto<>();
        Long totalCnt = dcMapper.selectDcListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<DcEntity> list = dcMapper.selectDcList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
