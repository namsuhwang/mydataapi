package com.abcc.mydataapi.api.base.dc.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.dc.models.DcAddSearch;
import com.abcc.mydataapi.api.base.dc.models.entity.DcAddEntity;
import com.abcc.mydataapi.api.base.dc.models.form.DcAddForm;
import com.abcc.mydataapi.api.base.dc.repository.DcAddMapper;
import com.abcc.mydataapi.api.base.dc.service.DcAddService;
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
    public void regDcAdd(DcAddForm dom) {
        dcAddMapper.insertDcAdd(dom.getEntity());
        return;
    }

    @Override
    public void updDcAdd(DcAddForm dom) {
        dcAddMapper.updateDcAdd(dom.getEntity());
        return;
    }

    @Override
    public void modDcAdd(DcAddForm dom) {
        if(getDcAdd(new DcAddSearch(dom)) == null){
            regDcAdd(dom);
        }else {
            updDcAdd(dom);
        }
        return;
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
    public DcAddEntity getDcAddLast(DcAddSearch dom) {
        return dcAddMapper.selectDcAddLast(dom);
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
