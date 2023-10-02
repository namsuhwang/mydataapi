package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteItfnMapper {

    int deleteItfnAcc(DeleteKeyDto dom);

    int deleteItfnCust(DeleteKeyDto dom);

    int deleteItfnLeaseHist(DeleteKeyDto dom);

    int deleteItfnLease(DeleteKeyDto dom);

    int deleteItfnLoanAdd(DeleteKeyDto dom);

    int deleteItfnLoanHist(DeleteKeyDto dom);

    int deleteItfnLoanHistInt(DeleteKeyDto dom);

}
