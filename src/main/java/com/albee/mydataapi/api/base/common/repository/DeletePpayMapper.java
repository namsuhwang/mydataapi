package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeletePpayMapper {

    int deletePpayAprHist(DeleteKeyDto dom);

    int deletePpayBal(DeleteKeyDto dom);

    int deletePpayHist(DeleteKeyDto dom);

    int deletePpay(DeleteKeyDto dom);
}
