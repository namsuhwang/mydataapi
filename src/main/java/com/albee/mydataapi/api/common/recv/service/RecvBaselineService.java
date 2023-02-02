package com.albee.mydataapi.api.common.recv.service;

import com.albee.mydataapi.api.common.recv.models.RecvBaselineSearch;
import com.albee.mydataapi.api.common.gateway.models.entity.EntityBase;
import com.albee.mydataapi.api.common.recv.models.entity.RecvBaselineEntity;
import com.albee.mydataapi.api.common.recv.models.form.RecvBaselineForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;


public interface RecvBaselineService{
    public void regRecvBaseline(RecvBaselineForm dom);

    public void updRecvBaseline(RecvBaselineForm dom);

    public void modRecvBaseline(RecvBaselineForm dom);

    public void  delRecvBaseline(RecvBaselineForm dom);

    public RecvBaselineEntity getRecvBaseline(EntityBase dom);

    public RecvBaselineEntity getRecvBaseline(RecvBaselineSearch dom);

    public ResultListDto<RecvBaselineEntity> getRecvBaselineList(RecvBaselineSearch dom);
}
