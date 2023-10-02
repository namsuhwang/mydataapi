package com.albee.mydataapi.api.collect.pull.service;


import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullCardService {

    public CompletableFuture<List<String>> pullCardInfoRun(ApiCallReqDto reqInfo, RecvStatusForm recvStatusForm);

}
