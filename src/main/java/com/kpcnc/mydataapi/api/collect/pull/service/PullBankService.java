package com.kpcnc.mydataapi.api.collect.pull.service;


import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallReqDto;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvStatusForm;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullBankService {

    public CompletableFuture<List<String>> pullBankInfoRun(ApiCallReqDto reqInfo, RecvStatusForm recvStatusForm);

}
