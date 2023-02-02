package com.abcc.mydataapi.api.common.recv.service;

import com.abcc.mydataapi.common.models.dto.ResultListDto;
import com.abcc.mydataapi.api.common.recv.models.RecvStatusSearch;
import com.abcc.mydataapi.api.common.recv.models.entity.RecvStatusEntity;
import com.abcc.mydataapi.api.common.recv.models.form.RecvStatusForm;

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
