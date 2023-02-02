package com.abcc.mydataapi.api.common.member.service;


import com.abcc.mydataapi.api.common.member.models.member.MemberSearch;
import com.abcc.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.abcc.mydataapi.api.common.member.models.member.form.MemberForm;
import com.abcc.mydataapi.common.models.dto.ResultListDto;

public interface MemberService {
    public MemberEntity regMember(MemberForm dom);

    public MemberEntity modMember(MemberForm dom);

    public MemberEntity getMember(String memberId);

    public ResultListDto<MemberEntity> getMemberList(MemberSearch dom);
}
