package com.albee.mydataapi.api.common.member.repository;

import com.albee.mydataapi.api.common.member.models.member.MemberTokenSearch;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberTokenMapper{

    int createSendReqSeq(MemberTokenSearch dom);

    int insertMemberToken(MemberTokenEntity dom);

    int updateMemberToken(MemberTokenEntity dom);

    int deleteMemberToken(MemberTokenEntity dom);

    MemberTokenEntity selectMemberToken(MemberTokenSearch dom);

    Long selectMemberTokenListTotalCnt(MemberTokenSearch dom);

    List<MemberTokenEntity> selectMemberTokenList(MemberTokenSearch dom);
}
