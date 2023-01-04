package com.kpcnc.mydataapi.service;

import com.kpcnc.mydataapi.models.member.MemberSearch;
import com.kpcnc.mydataapi.models.member.entity.MemberEntity;
import com.kpcnc.mydataapi.models.member.form.MemberForm;

import java.util.List;

public interface MemberService {
    public MemberEntity regMember(MemberForm dom);

    public MemberEntity modMember(MemberForm dom);

    public MemberEntity getMember(String memberId);

    public List<MemberEntity> getMemberList(MemberSearch dom);
}
