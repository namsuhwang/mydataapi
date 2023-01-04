package com.kpcnc.mydataapi.repository;

import com.kpcnc.mydataapi.models.member.MemberSearch;
import com.kpcnc.mydataapi.models.member.dto.MemberDto;
import com.kpcnc.mydataapi.models.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    String createMemberId();

    int insertMember(MemberEntity dom);

    int updateMember(MemberEntity dom);


    List<MemberEntity> selectMemberList(MemberSearch dom);

    MemberEntity selectMember(String memberId);


}
