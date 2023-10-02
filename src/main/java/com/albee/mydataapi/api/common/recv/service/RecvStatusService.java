package com.albee.mydataapi.api.common.recv.service;

import com.albee.mydataapi.common.models.dto.ResultListDto;
import com.albee.mydataapi.api.common.recv.models.RecvStatusSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvStatusEntity;
import com.albee.mydataapi.api.common.recv.models.form.RecvStatusForm;

public interface RecvStatusService{
    public String createRecvSeq(RecvStatusForm dom);

    public void regRecvStatus(RecvStatusForm dom);

    public void updRecvStatus(RecvStatusForm dom);

    public void updRecvStatus(RecvStatusForm dom, Integer incCnt, String orgCd);

    public void modRecvStatus(RecvStatusForm dom);

    public void  delRecvStatus(RecvStatusForm dom);

    public RecvStatusEntity getRecvStatus(RecvStatusSearch dom);

    public ResultListDto<RecvStatusEntity> getRecvStatusList(RecvStatusSearch dom);
}
