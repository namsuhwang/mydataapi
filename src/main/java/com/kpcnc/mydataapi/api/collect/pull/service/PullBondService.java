package com.kpcnc.mydataapi.api.collect.pull.service;


import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullBondService {

    public CompletableFuture<List<String>> pullBondInfoRun(ApiCallReqDto reqInfo, FormBase formBase);

}
