package com.abcc.mydataapi.api.collect.pull.service;


import com.abcc.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.abcc.mydataapi.api.common.recv.models.form.RecvStatusForm;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullCardService {

    public CompletableFuture<List<String>> pullCardInfoRun(ApiCallReqDto reqInfo, RecvStatusForm recvStatusForm);

}
