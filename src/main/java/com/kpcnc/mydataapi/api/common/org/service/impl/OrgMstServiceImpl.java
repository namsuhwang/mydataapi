package com.kpcnc.mydataapi.api.common.org.service.impl;

import com.kpcnc.mydataapi.api.common.org.models.OrgMstSearch;
import com.kpcnc.mydataapi.api.common.org.models.entity.OrgMstEntity;
import com.kpcnc.mydataapi.api.common.org.models.form.OrgMstForm;
import com.kpcnc.mydataapi.api.common.org.repository.OrgMstMapper;
import com.kpcnc.mydataapi.api.common.org.service.OrgMstService;
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
public class OrgMstServiceImpl implements OrgMstService {
    @Autowired
    OrgMstMapper orgMstMapper;

    @Override
    public OrgMstEntity regOrgMst(OrgMstForm dom) {
        orgMstMapper.insertOrgMst(dom.getEntity());
        return orgMstMapper.selectOrgMst(new OrgMstSearch(dom));
    }

    @Override
    public OrgMstEntity modOrgMst(OrgMstForm dom) {
        orgMstMapper.updateOrgMst(dom.getEntity());
        return orgMstMapper.selectOrgMst(new OrgMstSearch(dom));
    }

    @Override
    public void delOrgMst(OrgMstForm dom) {
        orgMstMapper.deleteOrgMst(dom.getEntity());
        return;
    }

    @Override
    public OrgMstEntity getOrgMst(OrgMstSearch dom) {
        return orgMstMapper.selectOrgMst(dom);
    }

    @Override
    public ResultListDto<OrgMstEntity> getOrgMstList(OrgMstSearch dom) {
        ResultListDto<OrgMstEntity> result = new ResultListDto<>();
        Long totalCnt = orgMstMapper.selectOrgMstListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<OrgMstEntity> list = orgMstMapper.selectOrgMstList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
