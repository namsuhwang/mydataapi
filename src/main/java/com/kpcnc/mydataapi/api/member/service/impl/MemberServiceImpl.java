package com.kpcnc.mydataapi.api.member.service.impl;

import com.kpcnc.mydataapi.api.member.models.member.entity.MemberEntity;
import com.kpcnc.mydataapi.api.member.repository.MemberMapper;
import com.kpcnc.mydataapi.api.member.models.member.MemberSearch;
import com.kpcnc.mydataapi.api.member.models.member.form.MemberForm;
import com.kpcnc.mydataapi.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public MemberEntity regMember(MemberForm dom) {
        MemberEntity inputEntity = new MemberEntity();
        inputEntity.setMemberName(dom.getMemberName());
        inputEntity.setUserToken(dom.getUserToken());
        inputEntity.setMemberId(memberMapper.createMemberId());
        memberMapper.insertMember(inputEntity);

        return memberMapper.selectMember(inputEntity.getMemberId());
    }

    @Override
    public MemberEntity modMember(MemberForm dom) {
        MemberEntity inputEntity = new MemberEntity();
        inputEntity.setMemberId(dom.getMemberId());
        inputEntity.setMemberName(dom.getMemberName());
        inputEntity.setUserToken(dom.getUserToken());
        memberMapper.updateMember(inputEntity);

        return memberMapper.selectMember(inputEntity.getMemberId());
    }

    @Override
    public MemberEntity getMember(String memberId) {

        return memberMapper.selectMember(memberId);
    }

    @Override
    public List<MemberEntity> getMemberList(MemberSearch dom) {

        return memberMapper.selectMemberList(dom);
    }
}
