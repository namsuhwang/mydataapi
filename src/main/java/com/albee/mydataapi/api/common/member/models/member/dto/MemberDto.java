package com.albee.mydataapi.api.common.member.models.member.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
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

}
