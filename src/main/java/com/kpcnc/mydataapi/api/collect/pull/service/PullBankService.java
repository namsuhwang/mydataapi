package com.kpcnc.mydataapi.api.collect.pull.service;


import com.kpcnc.mydataapi.api.collect.pull.models.form.PullForm;
import com.kpcnc.mydataapi.api.common.gateway.models.dto.ApiCallRequestInfoDto;
import com.kpcnc.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.kpcnc.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvStatusForm;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface PullBankService {

    public CompletableFuture<List<String>> pullBankInfoRun(ApiCallRequestInfoDto reqInfo, RecvStatusForm recvStatusForm);

}
