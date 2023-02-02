package com.albee.mydataapi.api.common.recv.service;

import com.albee.mydataapi.api.common.recv.models.RecvHistBaseSearch;
import com.albee.mydataapi.api.common.recv.models.entity.RecvHistBaseEntity;
import com.albee.mydataapi.api.common.recv.models.form.RecvHistBaseForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface RecvHistBaseService{

    public void regRecvHistBase(RecvHistBaseForm dom);

    public void updRecvHistBase(RecvHistBaseForm dom);

    public void modRecvHistBase(RecvHistBaseForm dom);

    public void  delRecvHistBase(RecvHistBaseForm dom);

    public RecvHistBaseEntity getRecvHistBase(RecvHistBaseSearch dom);

    public ResultListDto<RecvHistBaseEntity> getRecvHistBaseList(RecvHistBaseSearch dom);
}
