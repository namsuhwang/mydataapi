package com.kpcnc.mydataapi.api.collect.pull.service;


import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.kpcnc.mydataapi.api.common.gateway.models.form.FormBase;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvStatusForm;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullCardService {

    public CompletableFuture<List<String>> pullCardInfoRun(ApiCallReqDto reqInfo, RecvStatusForm recvStatusForm);

}
