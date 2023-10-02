package com.albee.mydataapi.api.common.recv.service;

import com.albee.mydataapi.api.common.recv.models.RecvHistDetailSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvHistDetailEntity;
import com.albee.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.albee.mydataapi.api.common.recv.models.form.RecvHistDetailForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface RecvHistDetailService{
    public Long createRecvDetailSeq();

    public void regRecvHistDetail(RecvHistBaseForm recvHistBaseForm, String resultJson);

    public void regRecvHistDetail(RecvHistDetailForm dom);

    public void updRecvHistDetail(RecvHistDetailForm dom);

    public void modRecvHistDetail(RecvHistDetailForm dom);

    public void  delRecvHistDetail(RecvHistDetailForm dom);

    public RecvHistDetailEntity getRecvHistDetail(RecvHistDetailSearch dom);

    public ResultListDto<RecvHistDetailEntity> getRecvHistDetailList(RecvHistDetailSearch dom);
}
