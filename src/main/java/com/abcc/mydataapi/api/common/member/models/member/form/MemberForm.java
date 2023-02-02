package com.abcc.mydataapi.api.common.member.models.member.form;


import com.abcc.mydataapi.api.common.member.models.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberForm {
    private String memberId;
    private String ci;
    private String memberRn;
    private String memberPwd;
    private String memberName;
    private String memberStatus;
    private String joinDt;
    private String leaveDt;
    private String lastContactDt;
    private String regUserId;
    private String regDt;
    private String chgUserId;
    private String chgDt;

    public MemberEntity getEntity(){
        MemberEntity entity = new MemberEntity();
        entity.setMemberId(memberId);
        entity.setCi(ci);
        entity.setMemberRn(memberRn);
        entity.setMemberPwd(memberPwd);
        entity.setMemberName(memberName);
        entity.setMemberStatus(memberStatus);
        entity.setJoinDt(joinDt);
        entity.setLeaveDt(leaveDt);
        entity.setLastContactDt(lastContactDt);
        entity.setRegUserId(regUserId);
        entity.setRegDt(regDt);
        entity.setChgUserId(chgUserId);
        entity.setChgDt(chgDt);
        return entity;
    }
}
