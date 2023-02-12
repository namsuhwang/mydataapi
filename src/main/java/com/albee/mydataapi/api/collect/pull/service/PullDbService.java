package com.albee.mydataapi.api.collect.pull.service;


import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.common.models.form.FormBase;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullDbService {

    public CompletableFuture<List<String>> pullDbInfoRun(ApiCallReqDto reqInfo, FormBase formBase);

}
