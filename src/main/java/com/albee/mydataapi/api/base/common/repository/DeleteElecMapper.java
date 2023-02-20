package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteElecMapper {

    int deleteElecAcc(DeleteKeyDto dom);

    int deleteElecPayHist(DeleteKeyDto dom);

    int deleteElecPayMethod(DeleteKeyDto dom);

    int deleteElecPpayAcc(DeleteKeyDto dom);

    int deleteElecPpayAutoCharge(DeleteKeyDto dom);

    int deleteElecPpayBal(DeleteKeyDto dom);

    int deleteElecPpayHist(DeleteKeyDto dom);

    int deleteElecPpay(DeleteKeyDto dom);

}
