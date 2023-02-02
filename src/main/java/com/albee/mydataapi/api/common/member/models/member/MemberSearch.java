package com.albee.mydataapi.api.common.member.models.member;


import com.albee.mydataapi.common.models.dto.SearchDto;
import com.albee.mydataapi.api.common.member.models.member.entity.MemberEntity;
import com.albee.mydataapi.api.common.member.models.member.form.MemberForm;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
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
