package com.albee.mydataapi.api.common.trans.service;

import com.albee.mydataapi.api.common.gateway.models.res.ResRootDto;
import com.albee.mydataapi.api.common.trans.models.dto.CustJoinCheck;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestSpec;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestWithdraw;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;

public interface TransRequestService {
    public CustJoinCheck transRequest001(CustJoinCheck dom);

    public Boolean transRequest002(TransRequestSpec dom);

    public ResRootDto transRequest003(TransReqEntity dom);

    public Boolean transRequest004(TransRequestWithdraw dom);
}
