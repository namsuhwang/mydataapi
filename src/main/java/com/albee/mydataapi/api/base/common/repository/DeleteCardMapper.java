package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteCardMapper {

    int deleteCardAprDmHist(DeleteKeyDto dom);

    int deleteCardAprOsHist(DeleteKeyDto dom);

    int deleteCardBase(DeleteKeyDto dom);

    int deleteCardChargeAdd(DeleteKeyDto dom);

    int deleteCardCharge(DeleteKeyDto dom);

    int deleteCardDmPca(DeleteKeyDto dom);

    int deleteCardLoanLgHist(DeleteKeyDto dom);

    int deleteCardLoanLg(DeleteKeyDto dom);

    int deleteCardLoan(DeleteKeyDto dom);

    int deleteCardLoanSt(DeleteKeyDto dom);

    int deleteCard(DeleteKeyDto dom);

    int deleteCardOsPca(DeleteKeyDto dom);

    int deleteCardPayDetail(DeleteKeyDto dom);

    int deleteCardPay(DeleteKeyDto dom);

    int deleteCardPt(DeleteKeyDto dom);

    int deleteCardRv(DeleteKeyDto dom);

}
