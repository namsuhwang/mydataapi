package com.kpcnc.mydataapi.api.member.models.member.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    private String memberId;
    private String memberName;
    private String userToken;
}
