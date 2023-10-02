package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteP2pMapper {

    int deleteP2pLoanAdd(DeleteKeyDto dom);

    int deleteP2pLoanBase(DeleteKeyDto dom);

    int deleteP2pLoanHist(DeleteKeyDto dom);

    int deleteP2pLoan(DeleteKeyDto dom);
}
