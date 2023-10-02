package com.albee.mydataapi.api.common.member.service;

import com.albee.mydataapi.api.common.member.models.member.MemberTokenSearch;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.albee.mydataapi.api.common.member.models.member.form.MemberTokenForm;
import com.albee.mydataapi.common.models.dto.ResultListDto;

public interface MemberTokenService{
    int createSendReqSeq(MemberTokenSearch dom);

    public void regMemberToken(MemberTokenForm dom);

    public void updMemberToken(MemberTokenForm dom);


    public void updMemberToken(MemberTokenEntity dom);

    public void modMemberToken(MemberTokenForm dom);

    public void  delMemberToken(MemberTokenForm dom);

    public MemberTokenEntity getMemberToken(MemberTokenSearch dom);

    public ResultListDto<MemberTokenEntity> getMemberTokenList(MemberTokenSearch dom);
}
