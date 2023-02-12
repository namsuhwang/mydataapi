package com.albee.mydataapi.api.collect.pull.service;


import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullItfnService {

    public CompletableFuture<List<String>> pullItfnInfoRun(ApiCallReqDto reqInfo, RecvStatusForm recvStatusForm);

}
