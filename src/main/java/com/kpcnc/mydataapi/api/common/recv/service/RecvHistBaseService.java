package com.kpcnc.mydataapi.api.common.recv.service;

import com.kpcnc.mydataapi.api.common.recv.models.RecvHistBaseSearch;
import com.kpcnc.mydataapi.api.common.recv.models.entity.RecvHistBaseEntity;
import com.kpcnc.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface RecvHistBaseService{
    public void regRecvHistBase(RecvHistBaseForm dom);

    public void updRecvHistBase(RecvHistBaseForm dom);

    public void modRecvHistBase(RecvHistBaseForm dom);

    public void  delRecvHistBase(RecvHistBaseForm dom);

    public RecvHistBaseEntity getRecvHistBase(RecvHistBaseSearch dom);

    public ResultListDto<RecvHistBaseEntity> getRecvHistBaseList(RecvHistBaseSearch dom);
}
