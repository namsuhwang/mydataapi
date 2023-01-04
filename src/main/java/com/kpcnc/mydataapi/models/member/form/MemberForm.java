package com.kpcnc.mydataapi.models.member.form;


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
    private String memberName;
    private String userToken;
}
