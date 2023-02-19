package com.albee.mydataapi.api.base.common.repository;

import com.albee.mydataapi.api.base.common.models.dto.DeleteKeyDto;
import org.springframework.stereotype.Component;

@Component
public interface DeleteInsuMapper {

    int deleteInsuBaseInsd(DeleteKeyDto dom);

    int deleteInsuBase(DeleteKeyDto dom);

    int deleteInsuCarHist(DeleteKeyDto dom);

    int deleteInsuCar(DeleteKeyDto dom);

    int deleteInsuGurt(DeleteKeyDto dom);

    int deleteInsuHist(DeleteKeyDto dom);

    int deleteInsuInsdBase(DeleteKeyDto dom);

    int deleteInsuInsdCar(DeleteKeyDto dom);

    int deleteInsuInsdGurt(DeleteKeyDto dom);

    int deleteInsuInsd(DeleteKeyDto dom);

    int deleteInsuInsdMiBase(DeleteKeyDto dom);

    int deleteInsuInsdMiBasePp(DeleteKeyDto dom);

    int deleteInsuInsdMi(DeleteKeyDto dom);

    int deleteInsuInsdMiSccont(DeleteKeyDto dom);

    int deleteInsuInsdSccont(DeleteKeyDto dom);

    int deleteInsuLoanAdd(DeleteKeyDto dom);

    int deleteInsuLoanBase(DeleteKeyDto dom);

    int deleteInsuLoanHistInt(DeleteKeyDto dom);

    int deleteInsuLoanHist(DeleteKeyDto dom);

    int deleteInsuLoan(DeleteKeyDto dom);

    int deleteInsu(DeleteKeyDto dom);

    int deleteInsuMiBase(DeleteKeyDto dom);

    int deleteInsuMiBasePp(DeleteKeyDto dom);

    int deleteInsuMiHist(DeleteKeyDto dom);

    int deleteInsuMi(DeleteKeyDto dom);

    int deleteInsuMiPay(DeleteKeyDto dom);

    int deleteInsuMiSccont(DeleteKeyDto dom);

    int deleteInsuPay(DeleteKeyDto dom);

    int deleteInsuSccont(DeleteKeyDto dom);


}
