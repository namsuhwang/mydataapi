package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteDcMapper {

    int deleteDc(DeleteKeyDto dom);

    int deleteDcBase(DeleteKeyDto dom);

    int deleteDcAdd(DeleteKeyDto dom);

    int deleteDcHist(DeleteKeyDto dom);

}
