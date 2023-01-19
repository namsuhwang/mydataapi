package com.kpcnc.mydataapi.api.common.api.service.impl;

import com.kpcnc.mydataapi.api.common.api.models.ApiMstSearch;
import com.kpcnc.mydataapi.api.common.api.models.entity.ApiMstEntity;
import com.kpcnc.mydataapi.api.common.api.models.form.ApiMstForm;
import com.kpcnc.mydataapi.api.common.api.repository.ApiMstMapper;
import com.kpcnc.mydataapi.api.common.api.service.ApiMstService;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class ApiMstServiceImpl implements ApiMstService {
    @Autowired
    ApiMstMapper apiMstMapper;

    @Override
    public ApiMstEntity regApiMst(ApiMstForm dom) {
        apiMstMapper.insertApiMst(dom.getEntity());
        return apiMstMapper.selectApiMst(new ApiMstSearch(dom));
    }

    @Override
    public ApiMstEntity modApiMst(ApiMstForm dom) {
        apiMstMapper.updateApiMst(dom.getEntity());
        return apiMstMapper.selectApiMst(new ApiMstSearch(dom));
    }

    @Override
    public void delApiMst(ApiMstForm dom) {
        apiMstMapper.deleteApiMst(dom.getEntity());
        return;
    }

    @Override
    public ApiMstEntity getApiMst(ApiMstSearch dom) {
        return apiMstMapper.selectApiMst(dom);
    }

    @Override
    public ResultListDto<ApiMstEntity> getApiMstList(ApiMstSearch dom) {
        ResultListDto<ApiMstEntity> result = new ResultListDto<>();
        Long totalCnt = apiMstMapper.selectApiMstListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<ApiMstEntity> list = apiMstMapper.selectApiMstList(dom);
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }


    /*
        in : scope (예 : bank.deposit)
        out : scope에 해당하는 API ID 목록(예 :  BANK_002, BANK_003, BANK_004, BANK_014)
     */
    @Override
    public List<ApiMstEntity> getApiListByScope(String scope){
        List<ApiMstEntity> apiMstlist = getApiMstList(new ApiMstSearch(scope)).getList();
        return apiMstlist;
    }
}
