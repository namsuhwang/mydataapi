package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteTeleMapper {

    int deleteTeleCharge(DeleteKeyDto dom);

    int deleteTeleCont(DeleteKeyDto dom);

    int deleteTeleHist(DeleteKeyDto dom);

    int deleteTelePay(DeleteKeyDto dom);

}
