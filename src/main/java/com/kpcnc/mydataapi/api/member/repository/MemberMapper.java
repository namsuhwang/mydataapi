package com.kpcnc.mydataapi.api.member.repository;

import com.kpcnc.mydataapi.api.member.models.member.MemberSearch;
import com.kpcnc.mydataapi.api.member.models.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberMapper {

    String createMemberId();

    int insertMember(MemberEntity dom);

    int updateMember(MemberEntity dom);


    List<MemberEntity> selectMemberList(MemberSearch dom);

    MemberEntity selectMember(String memberId);


}
