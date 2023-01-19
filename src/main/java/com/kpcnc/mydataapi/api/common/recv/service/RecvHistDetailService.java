package com.kpcnc.mydataapi.api.common.recv.service;

import com.kpcnc.mydataapi.api.common.recv.models.RecvHistDetailSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvHistDetailEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistDetailForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

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
