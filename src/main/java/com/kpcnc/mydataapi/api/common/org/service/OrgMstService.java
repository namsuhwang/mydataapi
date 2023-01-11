package com.kpcnc.mydataapi.api.common.org.service;

import com.kpcnc.mydataapi.api.common.org.models.OrgMstSearch;
import com.kpcnc.mydataapi.api.common.org.models.entity.OrgMstEntity;
import com.kpcnc.mydataapi.api.common.org.models.form.OrgMstForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

import java.util.List;

public interface OrgMstService{
    public OrgMstEntity regOrgMst(OrgMstForm dom);

    public OrgMstEntity modOrgMst(OrgMstForm dom);

    public void  delOrgMst(OrgMstForm dom);

    public OrgMstEntity getOrgMst(OrgMstSearch dom);

    public ResultListDto<OrgMstEntity> getOrgMstList(OrgMstSearch dom);
}
