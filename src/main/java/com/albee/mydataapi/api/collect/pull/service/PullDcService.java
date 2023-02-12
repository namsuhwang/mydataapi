package com.albee.mydataapi.api.collect.pull.service;


import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.common.models.form.FormBase;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullDcService {

    public CompletableFuture<List<String>> pullDcInfoRun(ApiCallReqDto reqInfo, FormBase formBase);

}
