package com.kpcnc.mydataapi.api.common.recv.service;

import com.kpcnc.mydataapi.api.common.recv.models.RecvStatusSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvStatusEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvStatusForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface RecvStatusService{
    public String createRecvSeq(RecvStatusForm dom);

    public RecvStatusEntity regRecvStatus(RecvStatusForm dom);

    public RecvStatusEntity updRecvStatus(RecvStatusForm dom);
    public RecvStatusEntity modRecvStatus(RecvStatusForm dom);

    public void  delRecvStatus(RecvStatusForm dom);

    public RecvStatusEntity getRecvStatus(RecvStatusSearch dom);

    public ResultListDto<RecvStatusEntity> getRecvStatusList(RecvStatusSearch dom);
}
