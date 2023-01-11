package com.kpcnc.mydataapi.api.common.member.service;


import com.kpcnc.mydataapi.api.common.member.models.member.MemberSearch;
import com.kpcnc.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.kpcnc.mydataapi.api.common.member.models.member.form.MemberForm;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;

public interface MemberService {
    public MemberEntity regMember(MemberForm dom);

    public MemberEntity modMember(MemberForm dom);

    public MemberEntity getMember(String memberId);

    public ResultListDto<MemberEntity> getMemberList(MemberSearch dom);
}
