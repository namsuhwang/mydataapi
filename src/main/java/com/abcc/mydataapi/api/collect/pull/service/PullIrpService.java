package com.abcc.mydataapi.api.collect.pull.service;


import com.abcc.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.abcc.mydataapi.api.common.gateway.models.form.FormBase;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullIrpService {

    public CompletableFuture<List<String>> pullIrpInfoRun(ApiCallReqDto reqInfo, FormBase formBase);

}
