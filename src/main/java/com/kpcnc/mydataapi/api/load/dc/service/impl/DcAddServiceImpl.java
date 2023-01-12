package com.kpcnc.mydataapi.api.load.dc.service.impl;

import com.kpcnc.mydataapi.api.load.dc.models.DcAddSearch;
import com.kpcnc.mydataapi.api.load.dc.models.entity.DcAddEntity;
import com.kpcnc.mydataapi.api.load.dc.models.form.DcAddForm;
import com.kpcnc.mydataapi.api.load.dc.repository.DcAddMapper;
import com.kpcnc.mydataapi.api.load.dc.service.DcAddService;
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
public class DcAddServiceImpl implements DcAddService {
    @Autowired
    DcAddMapper dcAddMapper;

    @Override
    public DcAddEntity regDcAdd(DcAddForm dom) {
        dcAddMapper.insertDcAdd(dom.getEntity());
        return dcAddMapper.selectDcAdd(new DcAddSearch(dom));
    }

    @Override
    public DcAddEntity modDcAdd(DcAddForm dom) {
        dcAddMapper.updateDcAdd(dom.getEntity());
        return dcAddMapper.selectDcAdd(new DcAddSearch(dom));
    }

    @Override
    public void delDcAdd(DcAddForm dom) {
        dcAddMapper.deleteDcAdd(dom.getEntity());
        return;
    }

    @Override
    public DcAddEntity getDcAdd(DcAddSearch dom) {
        return dcAddMapper.selectDcAdd(dom);
    }

    @Override
    public ResultListDto<DcAddEntity> getDcAddList(DcAddSearch dom) {
        ResultListDto<DcAddEntity> result = new ResultListDto<>();
        Long totalCnt = dcAddMapper.selectDcAddListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<DcAddEntity> list = dcAddMapper.selectDcAddList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
