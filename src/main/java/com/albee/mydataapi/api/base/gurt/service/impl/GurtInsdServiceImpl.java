package com.albee.mydataapi.api.base.gurt.service.impl;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.base.gurt.models.GurtInsdSearch;
import com.albee.mydataapi.api.base.gurt.models.entity.GurtInsdEntity;
import com.albee.mydataapi.api.base.gurt.models.form.GurtInsdForm;
import com.albee.mydataapi.api.base.gurt.repository.GurtInsdMapper;
import com.albee.mydataapi.api.base.gurt.service.GurtInsdService;
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
public class GurtInsdServiceImpl implements GurtInsdService {
    @Autowired
    GurtInsdMapper gurtInsdMapper;

    @Override
    public GurtInsdEntity regGurtInsd(GurtInsdForm dom) {
        gurtInsdMapper.insertGurtInsd(dom.getEntity());
        return gurtInsdMapper.selectGurtInsd(new GurtInsdSearch(dom));
    }

    @Override
    public GurtInsdEntity modGurtInsd(GurtInsdForm dom) {
        gurtInsdMapper.updateGurtInsd(dom.getEntity());
        return gurtInsdMapper.selectGurtInsd(new GurtInsdSearch(dom));
    }

    @Override
    public void delGurtInsd(GurtInsdForm dom) {
        gurtInsdMapper.deleteGurtInsd(dom.getEntity());
        return;
    }

    @Override
    public GurtInsdEntity getGurtInsd(GurtInsdSearch dom) {
        return gurtInsdMapper.selectGurtInsd(dom);
    }

    @Override
    public ResultListDto<GurtInsdEntity> getGurtInsdList(GurtInsdSearch dom) {
        ResultListDto<GurtInsdEntity> result = new ResultListDto<>();
        Long totalCnt = gurtInsdMapper.selectGurtInsdListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<GurtInsdEntity> list = gurtInsdMapper.selectGurtInsdList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
