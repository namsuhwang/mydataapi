package com.albee.mydataapi.api.common.auth.service;

import com.albee.mydataapi.api.common.auth.models.dto.TotalAuthRequest;
import com.albee.mydataapi.api.common.auth.models.dto.TotalAuthResponse;
import com.albee.mydataapi.api.common.gateway.models.res.ResRootDto;
import com.albee.mydataapi.api.common.trans.models.dto.CustJoinCheck;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestSpec;
import com.albee.mydataapi.api.common.trans.models.dto.TransRequestWithdraw;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;

public interface TotalAuthService {

    public TotalAuthResponse totalAuth002(TotalAuthRequest dom);

}
