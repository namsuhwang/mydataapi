package com.kpcnc.mydataapi.api.collect.pull.service;


import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullInvtService {

    public CompletableFuture<List<String>> pullInvtInfoRun(ApiCallReqDto reqInfo, FormBase formBase);

}
