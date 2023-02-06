package com.albee.mydataapi.api.common.trans.service;

import com.albee.mydataapi.api.common.gateway.models.res.ResRootDto;
import com.albee.mydataapi.api.common.trans.models.dto.CustJoinCheck;
import com.albee.mydataapi.api.common.trans.models.dto.ReplyTransRequestProcResult;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestRevokeRequest;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestSpec;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;

import java.util.HashMap;

public interface TransRequestService {
    public CustJoinCheck transRequest001(CustJoinCheck dom);

    public Boolean transRequest002(TransRequestSpec dom);

    public Boolean transRequest003(TransReqEntity dom);

    public ResRootDto transRequest004(TransRequestRevokeRequest dom);
}
