package com.albee.mydataapi.api.collect.pull.service;


import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullInvtService {

    public CompletableFuture<List<String>> pullInvtInfoRun(ApiCallReqDto reqInfo, RecvStatusForm recvStatusForm);

}
