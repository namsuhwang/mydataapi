package com.abcc.mydataapi.api.common.recv.service;

import com.abcc.mydataapi.api.common.recv.models.RecvHistBaseSearch;
import com.abcc.mydataapi.api.common.recv.models.entity.RecvHistBaseEntity;
import com.abcc.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface RecvHistBaseService{

    public void regRecvHistBase(RecvHistBaseForm dom);

    public void updRecvHistBase(RecvHistBaseForm dom);

    public void modRecvHistBase(RecvHistBaseForm dom);

    public void  delRecvHistBase(RecvHistBaseForm dom);

    public RecvHistBaseEntity getRecvHistBase(RecvHistBaseSearch dom);

    public ResultListDto<RecvHistBaseEntity> getRecvHistBaseList(RecvHistBaseSearch dom);
}
