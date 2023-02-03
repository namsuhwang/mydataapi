package com.albee.mydataapi.api.collect.pull.service;


import com.albee.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.albee.mydataapi.api.common.gateway.models.form.FormBase;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullTeleService {

    public CompletableFuture<List<String>> pullTeleInfoRun(ApiCallReqDto reqInfo, RecvStatusForm recvStatusForm);

}
