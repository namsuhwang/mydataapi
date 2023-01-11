package com.kpcnc.mydataapi.api.common.member.models.member;


import com.kpcnc.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.kpcnc.mydataapi.api.common.member.models.member.form.MemberForm;
import com.kpcnc.mydataapi.common.models.dto.SearchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberSearch extends SearchDto {
    private String memberId;
    private String memberName;


    public MemberSearch(String memberId) {
        this.memberId = memberId;
    }

    public MemberSearch(MemberEntity entity) {
        this.memberId = entity.getMemberId();
    }

    public MemberSearch(MemberForm form) {
        MemberEntity entity = form.getEntity();
        this.memberId = entity.getMemberId();
    }

}
