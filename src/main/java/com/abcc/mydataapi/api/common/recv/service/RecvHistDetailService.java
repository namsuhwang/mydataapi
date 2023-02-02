package com.abcc.mydataapi.api.common.recv.service;

import com.abcc.mydataapi.api.common.recv.models.RecvHistDetailSearch;
import com.abcc.mydataapi.api.common.recv.models.entity.RecvHistDetailEntity;
import com.abcc.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.abcc.mydataapi.api.common.recv.models.form.RecvHistDetailForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

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
