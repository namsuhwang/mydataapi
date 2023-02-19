package com.albee.mydataapi.api.base.common.models.dto;

import com.albee.mydataapi.common.models.dto.SearchDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
public class DeleteKeyDto extends SearchDto {
    private String memberId;
    private String orgCd;
    private String asset;
    private String seqno;

    public DeleteKeyDto(String memberId, String orgCd, String asset) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.asset = asset;
    }

    public DeleteKeyDto(String memberId, String orgCd, String asset, String seqno) {
        this.memberId = memberId;
        this.orgCd = orgCd;
        this.asset = asset;
        this.seqno = seqno;
    }

    public DeleteKeyDto(String memberId, String orgCd) {
        this.memberId = memberId;
        this.orgCd = orgCd;
    }
}
