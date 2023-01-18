package com.kpcnc.mydataapi.api.common.recv.service;

import com.kpcnc.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvBaselineForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.HashMap;


public interface RequestParamsSetService {
    public HashMap<String, Object> getParamsBank001(String memberId, String orgCd);
}
