package com.albee.mydataapi.api.collect.pull.service;


import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullPpayService {

    public CompletableFuture<List<String>> pullPpayInfoRun(ApiCallReqDto reqInfo, FormBase formBase);

}
