package com.abcc.mydataapi.api.base.dc.service.impl;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.base.dc.models.DcBaseSearch;
import com.abcc.mydataapi.api.base.dc.models.entity.DcBaseEntity;
import com.abcc.mydataapi.api.base.dc.models.form.DcBaseForm;
import com.abcc.mydataapi.api.base.dc.repository.DcBaseMapper;
import com.abcc.mydataapi.api.base.dc.service.DcBaseService;
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
public class DcBaseServiceImpl implements DcBaseService {
    @Autowired
    DcBaseMapper dcBaseMapper;

    @Override
    public DcBaseEntity regDcBase(DcBaseForm dom) {
        dcBaseMapper.insertDcBase(dom.getEntity());
        return dcBaseMapper.selectDcBase(new DcBaseSearch(dom));
    }

    @Override
    public DcBaseEntity modDcBase(DcBaseForm dom) {
        dcBaseMapper.updateDcBase(dom.getEntity());
        return dcBaseMapper.selectDcBase(new DcBaseSearch(dom));
    }

    @Override
    public void delDcBase(DcBaseForm dom) {
        dcBaseMapper.deleteDcBase(dom.getEntity());
        return;
    }

    @Override
    public DcBaseEntity getDcBase(DcBaseSearch dom) {
        return dcBaseMapper.selectDcBase(dom);
    }

    @Override
    public ResultListDto<DcBaseEntity> getDcBaseList(DcBaseSearch dom) {
        ResultListDto<DcBaseEntity> result = new ResultListDto<>();
        Long totalCnt = dcBaseMapper.selectDcBaseListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<DcBaseEntity> list = dcBaseMapper.selectDcBaseList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
