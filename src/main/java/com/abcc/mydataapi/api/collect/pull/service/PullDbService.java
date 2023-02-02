package com.abcc.mydataapi.api.collect.pull.service;


import com.abcc.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullDbService {

    public CompletableFuture<List<String>> pullDbInfoRun(ApiCallReqDto reqInfo, FormBase formBase);

}
