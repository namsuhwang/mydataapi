package com.kpcnc.mydataapi.api.member.service;

import com.kpcnc.mydataapi.api.member.models.member.entity.MemberEntity;
import com.kpcnc.mydataapi.api.member.models.member.form.MemberForm;
import com.kpcnc.mydataapi.api.member.models.member.MemberSearch;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
    public MemberEntity regMember(MemberForm dom);

    public MemberEntity modMember(MemberForm dom);

    public MemberEntity getMember(String memberId);

    public List<MemberEntity> getMemberList(MemberSearch dom);
}
