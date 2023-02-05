package com.albee.mydataapi.api.common.trans.service;

import com.albee.mydataapi.api.common.trans.models.dto.CustJoinCheck;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestSpec;

import java.util.HashMap;

public interface TransRequestService {
    public CustJoinCheck transRequest001(CustJoinCheck dom);

    public Boolean transRequest002(TransRequestSpec dom);
}
