package com.kpcnc.mydataapi.api.common.recv.service;

import com.kpcnc.mydataapi.api.common.recv.models.RecvHistDetailSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvHistDetailEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistDetailForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface RecvHistDetailService{
    public RecvHistDetailEntity regRecvHistDetail(RecvHistDetailForm dom);

    public RecvHistDetailEntity modRecvHistDetail(RecvHistDetailForm dom);

    public void  delRecvHistDetail(RecvHistDetailForm dom);

    public RecvHistDetailEntity getRecvHistDetail(RecvHistDetailSearch dom);

    public ResultListDto<RecvHistDetailEntity> getRecvHistDetailList(RecvHistDetailSearch dom);
}
