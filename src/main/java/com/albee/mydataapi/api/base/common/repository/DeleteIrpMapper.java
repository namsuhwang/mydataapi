package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteIrpMapper {

    int deleteIrpAccAdd(DeleteKeyDto dom);

    int deleteIrpAccBase(DeleteKeyDto dom);

    int deleteIrpAccHist(DeleteKeyDto dom);

    int deleteIrpAcc(DeleteKeyDto dom);
}
