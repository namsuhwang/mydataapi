package com.kpcnc.mydataapi.models.member;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class MemberSearch {
    private String memberId;
    private String memberName;
    private String userToken;

    public MemberSearch() {
    }

    public MemberSearch(String memberId) {
        this.memberId = memberId;
    }
}
