package com.albee.mydataapi.api.common.org.service;

import com.albee.mydataapi.api.common.org.models.OrgMstSearch;
import com.albee.mydataapi.api.common.org.models.entity.OrgMstEntity;
import com.albee.mydataapi.api.common.org.models.form.OrgMstForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface OrgMstService{
    public OrgMstEntity regOrgMst(OrgMstForm dom);

    public OrgMstEntity modOrgMst(OrgMstForm dom);

    public void  delOrgMst(OrgMstForm dom);

    public OrgMstEntity getOrgMst(OrgMstSearch dom);

    public ResultListDto<OrgMstEntity> getOrgMstList(OrgMstSearch dom);
}
