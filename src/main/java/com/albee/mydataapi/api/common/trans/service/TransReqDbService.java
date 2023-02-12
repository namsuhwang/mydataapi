package com.albee.mydataapi.api.common.trans.service;

import com.albee.mydataapi.api.common.trans.models.TransReqSearch;
import com.albee.mydataapi.api.common.trans.models.entity.TransReqEntity;
import com.albee.mydataapi.api.common.trans.models.form.TransReqForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface TransReqDbService {
    public void regTransReq(TransReqForm dom);

    public void updTransReq(TransReqForm dom);

    public void modTransReq(TransReqForm dom);

    public void  delTransReq(TransReqForm dom);

    public TransReqEntity getTransReq(TransReqSearch dom);

    public ResultListDto<TransReqEntity> getTransReqList(TransReqSearch dom);
}
