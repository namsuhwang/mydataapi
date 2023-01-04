package com.kpcnc.mydataapi.models.member.dto;


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
    private String memberName;
    private String userToken;

}
