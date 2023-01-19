package com.kpcnc.mydataapi.api.common.member.service.impl;

import com.kpcnc.mydataapi.api.common.member.models.member.MemberTokenSearch;
import com.kpcnc.mydataapi.api.common.member.models.member.entity.MemberTokenEntity;
import com.kpcnc.mydataapi.api.common.member.models.member.form.MemberTokenForm;
import com.kpcnc.mydataapi.api.common.member.repository.MemberTokenMapper;
import com.kpcnc.mydataapi.api.common.member.service.MemberTokenService;
import com.kpcnc.mydataapi.common.CommUtil;
import com.kpcnc.mydataapi.common.models.dto.ResultListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class MemberTokenServiceImpl implements MemberTokenService {
    @Autowired
    MemberTokenMapper memberTokenMapper;

    @Override
    public MemberTokenEntity regMemberToken(MemberTokenForm dom) {
        memberTokenMapper.insertMemberToken(dom.getEntity());
        return memberTokenMapper.selectMemberToken(new MemberTokenSearch(dom));
    }

    @Override
    public MemberTokenEntity modMemberToken(MemberTokenForm dom) {
        memberTokenMapper.updateMemberToken(dom.getEntity());
        return memberTokenMapper.selectMemberToken(new MemberTokenSearch(dom));
    }

    @Override
    public void delMemberToken(MemberTokenForm dom) {
        memberTokenMapper.deleteMemberToken(dom.getEntity());
        return;
    }

    @Override
    public MemberTokenEntity getMemberToken(MemberTokenSearch dom) {
        MemberTokenEntity memberTokenEntity = memberTokenMapper.selectMemberToken(dom);
        // "bank.list bank.invest bank.irp" -(split)-> List<String> 로 변환
        memberTokenEntity.setScopeLists(Arrays.asList(memberTokenEntity.getScopeList().split(" ")));
        return memberTokenMapper.selectMemberToken(dom);
    }

    @Override
    public ResultListDto<MemberTokenEntity> getMemberTokenList(MemberTokenSearch dom) {
        ResultListDto<MemberTokenEntity> result = new ResultListDto<>();
        Long totalCnt = memberTokenMapper.selectMemberTokenListTotalCnt(dom);
        result.setTotalCnt(totalCnt != null ? totalCnt : 0L);
        if(result.getTotalCnt() > 0){
            List<MemberTokenEntity> list = memberTokenMapper.selectMemberTokenList(dom);
            if(!CommUtil.isListNullEmpty(list)){
                for(MemberTokenEntity token : list){
                    // "bank.list bank.invest bank.irp" -(split)-> List<String> 로 변환
                    token.setScopeLists(Arrays.asList(token.getScopeList().split(" ")));
                }
            }
            result.setList(list);
            result.setPageCnt(list != null && list.size() > 0 ? list.size() : 0);
        }
        return result;
    }
}
